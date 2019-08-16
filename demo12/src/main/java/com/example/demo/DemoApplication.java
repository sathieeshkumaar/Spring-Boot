package com.example.demo;

import com.example.demo.Data.DongleRepo;
import com.example.demo.Data.PostRepo;
import com.example.demo.Data.PrepaidPlanRepo;
import com.example.demo.Model.Dongle;
import com.example.demo.Model.PostPaid;
import com.example.demo.Model.PrepaidPlan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.demo.Data")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner dataLoader(DongleRepo repo, PostRepo repo1, PrepaidPlanRepo repo2) {
        repo.deleteAll();
        repo1.deleteAll();
        repo2.deleteAll();
        return args -> {
            repo.save(new Dongle("Voizfoni","180_days","190"));
            repo.save(new Dongle("Logitechi", "30_days","299"));
            repo.save(new Dongle("vifi", "365_days", "567"));
            repo.save(new Dongle("Cutters", "365_days", "507"));
            repo.save(new Dongle("Omni","180_days","200"));
            repo.save(new Dongle("5Gs", "300_days","799"));
            repo1.save(new PostPaid("Dhamaka-Deal","100days","190"));
            repo1.save(new PostPaid("Unlimited-Talks", "30_days","299"));
            repo1.save(new PostPaid("Datafi", "45_days", "567"));
            repo1.save(new PostPaid("Locals","50days","150"));
            repo1.save(new PostPaid("Get-Ready", "30_days","299"));
            repo1.save(new PostPaid("Myfamily", "45_days", "157"));
            repo2.save(new PrepaidPlan("voizi","28_days","190"));
            repo2.save(new PrepaidPlan("Preplan", "360_days","699"));
            repo2.save(new PrepaidPlan("Freedom", "2_days", "100"));
            repo2.save(new PrepaidPlan("Weekend-deal","28_days","190"));
            repo2.save(new PrepaidPlan("August-offer", "30_days","99"));
            repo2.save(new PrepaidPlan("Datag", "2_days", "100"));


        };
    }

}
