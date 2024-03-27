package com.example.springwebjdk17;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${mycustom.value1}")
    private String myCustomValue1;

    @GetMapping
    public String foo() {
        Person p1r = repo.findById(3L).orElse(null);
        if (p1r == null) return "Couldn't find the person, so here's the custom value[" + myCustomValue1 + "]";
        return "person's name=[" + p1r.getName() + "]";
//        return "myCustomValue1=[" + myCustomValue1 + "]";
//        return "myCustomValue1=[SHUT UP!]";
    }
    private final PersonRepo repo;
//
//    @Value("azure-blob://" + "${spring.cloud.azure.storage.blob.container-name}" + "/test.txt")
//    private Resource resource;
//
//    @Value("${spring.cloud.azure.storage.blob.connection-string}")
//    private String blobConnectionString;
//
//    @Value("${spring.cloud.azure.storage.blob.container-name}")
//    private String blobContainerName;
//
    public Controller(PersonRepo repo) {
        this.repo = repo;
    }
//
//    @GetMapping("/test")
//    public String testEndpoint() {
//        return "Hi World!";
//    }
//
//    @GetMapping("/dogs")
//    public ResponseEntity<List<Person>> getAllDogs() {
//        return ResponseEntity.ok((List<Person>) repo.findAll());
//    }

//    @PostMapping("/dogs")
//    public ResponseEntity<Void> addNewDog(@RequestBody PostRequestDogDto newDog) {
//        Dog addedDog = repo.save(new Dog(newDog.name(), newDog.birthYear(), newDog.breed()));
//        return ResponseEntity.created(URI.create("/dogs/" + addedDog.getId())).build();
//    }

//    @GetMapping("/dogs/{id}")
//    public ResponseEntity<DogResponseDto> getADog(@PathVariable String id) {
//        try {
//            Dog dog = repo.findById(id).orElseThrow();
//            return ResponseEntity.ok(new DogResponseDto(dog.getName(), dog.getBirthYear(), dog.getBreed()));
//        } catch (NoSuchElementException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @DeleteMapping("/dogs/{id}")
//    public ResponseEntity<Void> deleteDog(@PathVariable String id) {
//        repo.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping("/blob/test")
//    public String readFileBlob() throws IOException {
//        return StreamUtils.copyToString(this.resource.getInputStream(), Charset.defaultCharset());
//    }
//
//    @PostMapping("/blob/upload")
//    public void uploadFileBlob(@RequestParam("file") MultipartFile file) throws IOException {
//        BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
//                .connectionString(blobConnectionString)
//                .containerName(blobContainerName)
//                .buildClient();
//        BlobClient blob = blobContainerClient.getBlobClient(file.getOriginalFilename());
//        blob.upload(file.getInputStream(),file.getSize(),true);
//    }
}
