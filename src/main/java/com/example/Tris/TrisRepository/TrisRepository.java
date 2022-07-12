package com.example.Tris.TrisRepository;

import com.example.Tris.Model.Partita;
import com.example.Tris.Model.Utente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TrisRepository {

    private List<Partita> listapartite = new ArrayList<>();

    public  List<Partita> getAll(){
        return listapartite;
    }

    public Partita add(Partita partita){
        partita.setMatchid(listapartite.size() + 1);
        /*partita.getUtente1().setId(1);
        partita.getUtente1().setC('X');
        partita.getUtente2().setId(2);
        partita.getUtente2().setC('O');*/
        listapartite.add(partita);
        return partita;
    }

    public Optional<Partita> findByID(int id){
        return listapartite.parallelStream().filter(u -> u.getMatchid() == id).findFirst();
    }

    public Partita reset(int id){
        for(Partita p : listapartite){
            if (p.getMatchid() == id){
                for(int i = 1; i < listapartite.size() + 1; i++ )
                p.getGriglia().put(i, ' ');
                return p;
            }
        }
        return null;
    }

    public Partita move(int id,char c, int key){
        //char c = ' ';
        for(Partita p : listapartite) {
            /*if(p.getListamosse().size() % 2 == 0) {
                c = p.getUtente1().getC();
            }
            else{
                c = p.getUtente2().getC();
            }*/
                if (p.getMatchid() == id) {
                    if (p.getListamosse().size() == 9) {
                        p.setVincitore('P');
                        System.out.println("partita in pareggio");
                    }
                    if (p.getVincitore() == 'L') {
                        p.getGriglia().put(key, c);
                        p.addmossa(key);
                        if (p.getGriglia().get(1) == c && p.getGriglia().get(2) == c && p.getGriglia().get(3) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        if (p.getGriglia().get(4) == c && p.getGriglia().get(5) == c && p.getGriglia().get(6) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        if (p.getGriglia().get(7) == c && p.getGriglia().get(8) == c && p.getGriglia().get(9) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        if (p.getGriglia().get(1) == c && p.getGriglia().get(4) == c && p.getGriglia().get(7) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        if (p.getGriglia().get(2) == c && p.getGriglia().get(5) == c && p.getGriglia().get(8) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        if (p.getGriglia().get(3) == c && p.getGriglia().get(6) == c && p.getGriglia().get(9) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        if (p.getGriglia().get(1) == c && p.getGriglia().get(5) == c && p.getGriglia().get(9) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        if (p.getGriglia().get(3) == c && p.getGriglia().get(5) == c && p.getGriglia().get(7) == c) {
                            System.out.println("Il vincitore e': " + c);
                            p.setVincitore(c);
                        }
                        return p;
                    } else {
                        System.out.println("Partita terminata");
                        return p;
                    }
                }
        }
        return null;
    }

    public Partita back(int id){
        for(Partita p : listapartite) {
            if(p.getMatchid() == id) {
                int key = p.getListamosse().get(p.getListamosse().size() - 1);
                p.getGriglia().put(key, ' ');
                p.getListamosse().remove(p.getListamosse().size()- 1);
                return p;
            }
        }
        return null;
    }
}
