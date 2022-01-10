package main;

import main.response.Jig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JigController {

    @RequestMapping(value = "/jigs/", method = RequestMethod.GET)
    public ResponseEntity list(){
        Jig n3434 = new Jig("N3434");
        Jig t2520 = new Jig("T2520");
        Jig r2810 = new Jig("R2810");
        Jig rrr10 = new Jig("RRR10");
        JigStorage storage = new JigStorage("MainStorage", 5, 4);
        storage.addOneJig(n3434,5);
        storage.addOneJig(t2520,3);
        storage.addOneJig(r2810,6);
        storage.addOneJig(rrr10,7);

       storage.showStorage();
       return new ResponseEntity(HttpStatus.OK);
    }
}
