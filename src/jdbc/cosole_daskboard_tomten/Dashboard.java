package jdbc.cosole_daskboard_tomten;

import java.util.stream.Collectors;

public class Dashboard {

    public Dashboard(){
        RepositoryInterface r = new Uppkoppling();
        while(true){
            System.out.println("Antal nisse är: " + r.getAllNisse().size());
            r.getAllNisse().forEach(nisse -> System.out.println(nisse.getNamn()));
            //System.out.println("Nisses namn: " + r.getAllNisse().stream().map(Nisse::getNamn).collect(Collectors.toList()));
            System.out.println("Antal barn är: " + r.getAntalBarn());
            System.out.println("Medelvärdet för snällhet av barnen är: " + r.getGodhetAvg());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public static void main(String[] args) {
        Dashboard d = new Dashboard();
    }
}
