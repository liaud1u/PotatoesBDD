package fr.liaud1u.potatoesbdd;

import fr.liaud1u.potatoesbdd.model.Potato;
import fr.liaud1u.potatoesbdd.model.PotatoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class PotatoesBddApplication {

    public static void main(String[] args) {
        SpringApplication.run(PotatoesBddApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadVariety(PotatoRepository repository){
        return (args) -> {
            // Read the .csv file and put in BDD
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(
                        this.getClass().getClassLoader().getResourceAsStream("static/potatoes.csv")));

                String line = null;

                // Get the list of field of the csv file
                ArrayList<String> fields = new ArrayList<>();

                int cptId = 0;

                // For each line of csv
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(";");
                    HashMap<String, String> potatoData = new HashMap<>();
                    // For each row of csv
                    for (int i = 0; i < str.length; i++) {
                        if (cptId == 0) {
                            // If it's the first line, we add the string as a new field
                            fields.add(str[i]);
                        } else {
                            // We add the data to the map of potato data
                            if (i < fields.size())
                                potatoData.put(fields.get(i), str[i]);
                        }
                    }

                    // Conversion of the map of potato data to a map of potato
                    if (cptId != 0) {
                        Potato potato = new Potato(potatoData.get("Variety Name"),
                                potatoData.get("Description"),
                                potatoData.get("Parentage"),
                                potatoData.get("IVT Variety"),
                                potatoData.get("Breeder Country"),
                                potatoData.get("Colour of skin"),
                                potatoData.get("Colour of flesh"),
                                potatoData.get("Smoothness of skin"),
                                potatoData.get("Maturity"),
                                potatoData.get("Height of plants"),
                                potatoData.get("Colour of flower"));

                        repository.save(potato);
                    }
                    cptId++;
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Affichage de toutes les variétées: ");
            for(Potato potato : repository.findAll()){
                System.out.println(potato.toString());
            }

            System.out.println("\n--------------------\n");

            System.out.println("Affichage d'une seule variété findById(324)");
            System.out.println(repository.findById(324));

            System.out.println("\n--------------------\n");

            System.out.println("Affichage d'une seule couleur de peau de pomme de terre findByColourOfSkin(Cream)");
            repository.findByColourOfSkin("Cream").forEach(p->{
                System.out.println(p.toString());
            });
        };
    }
}
