package main;

import main.response.Jig;
import main.response.JigRepository;
import main.response.MainStorage;
import main.response.Storage;
import main.response.asssemblyBoard.AssemblyBoard;
import main.response.asssemblyBoard.AssemblyBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JigController {

    @Autowired
    private JigRepository jigRepository;

    @Autowired
    private AssemblyBoardRepository boardRepository;

    @RequestMapping(value = "/jigs/", method = RequestMethod.POST)
    public ResponseEntity add(@RequestParam(value = "pkcCode", required = true) String pkcCode,
                              @RequestParam(value = "qty", required = true) int qty) {
        Jig jig = new Jig(pkcCode, qty);
        jigRepository.save(jig);

        AssemblyBoard assemblyBoard = new AssemblyBoard("VOL25543409");
        assemblyBoard.addOneJig(jig);
        boardRepository.save(assemblyBoard);

        long newJig = jigRepository.count();
        System.out.println(newJig);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/jigs/", method = RequestMethod.DELETE)
    public ResponseEntity remove(@RequestParam(value = "pkcCode", required = true) String pkcCode) {
        int id = -1;
        Iterable<Jig> jigs = jigRepository.findAll();
        for (Jig jig : jigs) {
            if (jig.getPkcCode().equals(pkcCode)) {
                id = jig.getId();
                jigRepository.deleteById(id);
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        System.out.printf("Code,%s is not found\n", pkcCode);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
//    Iterable<Message> messages = messageRepository.findAll();
//        for(Message message : messages) {
//        MessageResponse messageItem = new MessageResponse();
//        messageItem.setName(message.getUser().getName());
//        messageItem.setTime(
//                formatter.format(message.getSendTime())
//        );
//        messageItem.setText(message.getText());
//        messagesList.add(messageItem);
//    }
//    HashMap<String, List> response = new HashMap<>();
//        response.put("messages", messagesList);
//        return response;


//    @GetMapping("/books/{id}")
//    public ResponseEntity<?> get(@PathVariable int id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if (!optionalBook.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/jigs/", method = RequestMethod.GET)
    public ResponseEntity list() {
        Jig n3434 = new Jig("N3434", 5);
        Jig t2520 = new Jig("T2520", 6);
        Jig r2810 = new Jig("R2810", 6);
        Jig rrr10 = new Jig("RRR10", 7);
        Jig rrr10_1 = new Jig("RRR10", 9);

        jigRepository.save(n3434);
        jigRepository.save(t2520);
        jigRepository.save(r2810);
        jigRepository.save(rrr10);
        jigRepository.save(rrr10_1);

//        JigStorage storage = new JigStorage("MainStorage", 5, 4);
//        storage.addOneJig(n3434, 5);
//        storage.addOneJig(t2520, 3);
//        storage.addOneJig(r2810, 6);
//        storage.addOneJig(rrr10, 7);
//
//        storage.showStorage();
        System.out.println("OOOK");
        return new ResponseEntity(HttpStatus.OK);
    }


}
