package salacinema;

import java.util.ArrayList;
import java.util.Scanner;

class Cliente{
    public String id;
    public String fone;
    public Cliente(String id, String fone){
        this.id = id;
        this.fone = fone;
    }
    public String toString(){
        return id + ":" + fone;
    }
}

class Sala{
    ArrayList<Cliente> cadeiras;
    public Sala(int limite){
        cadeiras = new ArrayList<Cliente>();
        for(int i = 0; i < limite; i++)
            cadeiras.add(null);
    }
    
    boolean reservar(String id, String fone, int ind){
        if((ind >= this.cadeiras.size()) || (ind < 0)){
            System.out.println("fail: Indice invalido!");
            return false;
        }
        if(this.cadeiras.get(ind) != null){
            System.out.println("fail: Cadeira já está ocupada!");
            return false;
        }
        for(Cliente cliente : this.cadeiras){
            if((cliente != null) && (cliente.id.equals(id))){
                System.out.println("fail: Cliente já está no cinema!");
                return false;
            }
        }
        this.cadeiras.set(ind, new Cliente(id, fone));
        return true;
    }
    
    void cancelar(String id){
        for(int i = 0; i < this.cadeiras.size(); i += 1){
            Cliente cliente = this.cadeiras.get(i);
            if((this.cadeiras.get(i) != null) && (this.cadeiras.get(i).id.equals(id))){
                this.cadeiras.set(i, null);
                return;
            }
        }
        System.out.println("fail: Cliente não está no cinema!");
    }
    
    public String toString(){
        String saida = "[";
        for(Cliente cliente : cadeiras){
            if(cliente == null)
                saida += "- ";
            else
                saida += cliente + " ";
        }
        saida += "]";
        return saida;
    }
}

public class SalaCinema {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Sala sala = new Sala(0);
        
        while(true){
            String line = scanner.nextLine();
            System.out.println(line);
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                sala = new Sala(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("show")){
                System.out.println(sala);
            }else if(ui[0].equals("reservar")){
                sala.reservar(ui[1], ui[2], Integer.parseInt(ui[3]));
            }else if(ui[0].equals("cancelar")){
                sala.cancelar(ui[1]);
            }else{
                System.out.println("fail: Comando invalido");
            }
        }
    }
}


