package main;

import main.response.Jig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        ConfigurableApplicationContext configurableApplicationContext =
//                SpringApplication.run(Main.class, args);

//        Beans
//        CartRepository cartRepository = configurableApplicationContext.getBean(CartRepository.class);
//        UniversityRepository universityRepository = configurableApplicationContext.getBean(UniversityRepository.class);
//        StudentRepository studentRepository = configurableApplicationContext.getBean(StudentRepository.class);
//        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
//        AddressRepository addressRepository = configurableApplicationContext.getBean(AddressRepository.class);
//        CarRepository carRepository = configurableApplicationContext.getBean(CarRepository.class);
//        OwnerRepository ownerRepository = configurableApplicationContext.getBean(OwnerRepository.class);
//        StreamRepository streamRepository = configurableApplicationContext.getBean(StreamRepository.class);
//        ViewerRepository viewerRepository = configurableApplicationContext.getBean(ViewerRepository.class);

//        System.out.println( n3434 + " " + t2520 + " " + r2810 + " " + rrr10);

//        HashMap<main.response.Jig, Integer> jigForStorage = new HashMap<main.response.Jig, Integer>();
//        jigForStorage.put(n3434, 5);
//        jigForStorage.put(t2520, 3);
//        jigForStorage.put(r2810, 2);
//        jigForStorage.put(rrr10, 1);
//
//        HashMap<main.response.Jig, Integer> jigNeededForHarn = new HashMap<main.response.Jig, Integer>();
//        jigNeededForHarn.put(n3434, 5);
//        jigNeededForHarn.put(t2520, 3);
//        jigNeededForHarn.put(r2810, 2);
//
//        HashMap<main.response.Jig, Integer> jigInstallHarness = new HashMap<main.response.Jig, Integer>();
//        jigInstallHarness.put(n3434, 1);
//        jigInstallHarness.put(t2520, 2);
//        jigInstallHarness.put(r2810, 3);
//
//        HashMap<main.response.Jig, Integer> jigsTrancfer = new HashMap<main.response.Jig, Integer>();
//        jigsTrancfer.put(n3434, 1);
//        jigsTrancfer.put(t2520, 1);
//        jigsTrancfer.put(r2810, 1);
//
//        main.response.asssemblyBoard.AssemblyBoard board = new main.response.asssemblyBoard.AssemblyBoard("Bord1", jigNeededForHarn);
//        board.showInstalledJigs();
//        board.installJigs(jigInstallHarness);
//        System.out.println("Board after:");
//        board.showInstalledJigs();
//
//        main.JigStorage storage = new main.JigStorage("main.JigStorage", 5, 4);
//        storage.installJigs(jigForStorage);
//
//        System.out.println("main.response.Storage after adding:");
//        storage.showStorage();
//
//        storage.transferJigs(board, jigsTrancfer);
//        storage.transferJigs(board, jigsTrancfer);
//
//        System.out.println("main.response.Storage after transfer:");
//        storage.showStorage();
//
//        System.out.println("Harness after transfer:");
//        board.showInstalledJigs();
//
//        System.out.println("Transfer back");
//        board.transferJigs(storage, jigsTrancfer);
//        board.transferJigs(storage, jigsTrancfer);
//        storage.showStorage();
//        board.showInstalledJigs();

    }
}
