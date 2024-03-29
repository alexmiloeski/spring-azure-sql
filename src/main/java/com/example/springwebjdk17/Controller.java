package com.example.springwebjdk17;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Value("azure-blob://" + "${spring.cloud.azure.storage.blob.container-name}" + "/text.txt")
    private Resource resource;

    @Value("${spring.cloud.azure.storage.blob.connection-string}")
    private String blobConnectionString;

    @Value("${spring.cloud.azure.storage.blob.container-name}")
    private String blobContainerName;

    @Value("${mycustom.value1}")
    private String myCustomValue1;

    private final PersonRepo repo;

    public Controller(PersonRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public String getAllPersons() {
        Iterable<Person> personIterable = repo.findAll();
        List<Person> personList = new ArrayList<>();
        personIterable.forEach(personList::add);
        if (personList.isEmpty()) {
            return "Couldn't find any persons.";
        }
        return "persons list=[" + personList + "]";
    }

    @GetMapping("{id}")
    public String getPersonById(@PathVariable long id) {
        Person p1r = repo.findById(id).orElse(null);
        if (p1r == null) return "Couldn't find that person";
        return "person's name=[" + p1r.getName() + "]";
    }

    @PostMapping("{id}")
    public void postPerson(@PathVariable long id, @NotBlank @RequestParam String name) {
        Person p1 = new Person(id, name);
        repo.save(p1);
    }

    @GetMapping("custom-value")
    public String getCustomValue() {
        return "custom value=[" + myCustomValue1 + "]";
    }

    @GetMapping("/blob/test")
    public String readFileBlob() throws IOException {
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }

    @GetMapping("/blob/all")
    public String listAllBlobs() {
        BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
                .connectionString(blobConnectionString)
                .containerName(blobContainerName)
                .buildClient();
        String blobNames = blobContainerClient.listBlobs().stream()
                .map(BlobItem::getName)
                .collect(Collectors.joining(",\n<br/>"));
        return "blobNames=[<br/>" + blobNames + "<br/>]";
    }

    @PostMapping("/blob/upload")
    public void uploadFileBlob(@RequestParam("file") MultipartFile file) throws IOException {
        BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
                .connectionString(blobConnectionString)
                .containerName(blobContainerName)
                .buildClient();
        BlobClient blob = blobContainerClient.getBlobClient(file.getOriginalFilename());
        blob.upload(file.getInputStream(),file.getSize(),true);
    }
}
