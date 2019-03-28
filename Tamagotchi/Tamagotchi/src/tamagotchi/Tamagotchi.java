package tamagotchi;

import java.util.Scanner;

public class Tamagotchi {
    String nome;
    int energia;
    int saciedade;
    int limpeza;
    int energiaMax;
    int saciedadeMax;
    int limpezaMax;
    
    public Tamagotchi(String nome, int energia, int saciedade, int limpeza){
        this.nome = nome;
        this.energia = energia;
        this.saciedade = saciedade;
        this.limpeza = limpeza;
        this.energiaMax = energia;
        this.saciedadeMax = saciedade;
        this.limpezaMax = limpeza;
    }

    public String toString(){
        return "[" + this.nome + "]" +
              " E: " + this.energia + "/" + this.energiaMax + 
              " S: " + this.saciedade + "/" + this.saciedadeMax + 
              " L: " + this.limpeza + "/" + this.limpezaMax;
    }   

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Tamagotchi pet = new Tamagotchi("", 0, 0, 0);
        System.out.println("Digite: end, init E S L, show");
        while(true){
            String line = scan.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                pet = new Tamagotchi(ui[1], Integer.parseInt(ui[2]), Integer.parseInt(ui[3]), Integer.parseInt(ui[4]));
            }else if(ui[0].equals("show")){
                System.out.print(pet);
            }else{
                System.out.print("Falha: comando invalido!");
            }
        } 
    }
}