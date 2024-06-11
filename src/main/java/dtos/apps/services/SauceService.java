package dtos.apps.services;


import org.springframework.stereotype.Service;
import dtos.apps.models.Sauce;
import dtos.apps.models.SauceDto;
import java.util.List;
import java.util.Optional;
import dtos.apps.repositories.SauceJpa;

@Service
public class SauceService {
    private final SauceJpa sauceJpa;

    public SauceService(SauceJpa jpa){
        this.sauceJpa=jpa;
    }
    public List<Sauce> index(){
        List<Sauce> sauces=sauceJpa.findAll();
        return sauces;
    }
    public Sauce post(SauceDto sauceDto){
        Sauce sauce=new Sauce();
        sauce.setName(sauceDto.getName());
        Sauce sauceSave=sauceJpa.save(sauce);
        return sauceSave;
    }
    public Sauce get(int id){
        Optional<Sauce> sauce=sauceJpa.findById(id);
        return sauce.get();

    }
    public Sauce update (int id,SauceDto sauceDto){
        Optional<Sauce> sauceFind=sauceJpa.findById(id);
        Sauce sauce=sauceFind.get();
        sauce.setName(sauceDto.getName());
        return sauceJpa.save(sauce);
    }

}
