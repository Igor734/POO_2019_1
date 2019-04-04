package morrepet;

import java.util.Scanner;


class Pet{
    String nome;
//ENERGIA
    public int getEnergia() {return energia;}

    public void setEnergia(int energia) {
        if(energia > this.energiaMax)
            this.energia = this.energiaMax;
        else if(energia <= 0){
            this.energia = 0;
            this.isAlive = false;
        }else
            this.energia = energia;
    }
//SACIEDADE
    public int getSaciedade() {return saciedade;}

    public void setSaciedade(int saciedade) {
        if(saciedade > this.saciedadeMax)
            this.saciedade = this.saciedadeMax;
        else if(saciedade <= 0){
            this.saciedade = 0;
            this.isAlive = false;
        }else
            this.saciedade = saciedade;
    }
//LIMPEZA
    public int getLimpeza() {return limpeza;}

    public void setLimpeza(int limpeza) {
        if(limpeza > this.limpezaMax)
            this.limpeza = this.limpezaMax;
        else if(limpeza < 0){
            this.limpeza = 0;
            this.isAlive = false;
        }else
            this.limpeza = limpeza;
    }
//ENERGIA_MAX
    public int getEnergiaMax() {return energiaMax;}
//SACIEDADE_MAX
    public int getSaciedadeMax() {return saciedadeMax;}
//LIMPEZA_MAX
    public int getLimpezaMax() {return limpezaMax;}
//IDADE
    public int getIdade() {return idade;}
//DIAMANTES
    public int getDiamantes() {return diamantes;}

    public boolean testAlive(){
        if(this.isAlive)
            return true;
        System.out.println("Falha: Seu Pet está morto!");
        return false;
    }
    
    public void play(){
        if(!this.testAlive())
            return;
        this.setEnergia(this.getEnergia() -2);
        this.setSaciedade(this.getSaciedade() -1);
        this.setLimpeza(this.getLimpeza() -3);
        this.diamantes += 1;
        this.idade += 1;
    }
    
    public void eat(){
        if(!this.testAlive())
            return;
        this.setEnergia(this.getEnergia() -1);
        this.setSaciedade(this.getSaciedade() +4);
        this.setLimpeza(this.getLimpeza() -2);
        this.idade += 1;
    }
    
    public void sleep(){
        if(!this.testAlive())
            return;
        if((this.energiaMax - this.energia) < 5){
            System.out.println("Falha: Seu Pet não está com sono!");
            return;
        }else{
            this.idade += this.energiaMax - this.energia;
            this.setEnergia(this.getEnergiaMax());
        }
    }
    
    public void clean(){
        if(!this.testAlive())
            return;
        this.setLimpeza(this.getLimpezaMax());
        this.setEnergia(this.getEnergia() -3);
        this.setSaciedade(this.getSaciedade() -1);
        this.idade +=2;
    }
    
    private int energia;
    private int saciedade;
    private int limpeza;
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int idade;
    private int diamantes;
    private boolean isAlive;
    
    public Pet(String nome, int energia, int saciedade, int limpeza){
        this.nome = nome;
        this.energia = energia;
        this.saciedade = saciedade;
        this.limpeza = limpeza;
        this.energiaMax = energia;
        this.saciedadeMax = saciedade;
        this.limpezaMax = limpeza;
        this.idade = 0;
        this.diamantes = 0;
        this.isAlive = true;
    }
    
    public String toString(){
        return "[" + this.nome + "]" +
              " E: " + this.energia + "/" + this.energiaMax + 
              " S: " + this.saciedade + "/" + this.saciedadeMax + 
              " L: " + this.limpeza + "/" + this.limpezaMax +
              " I: " + this.idade + " D: " + this.diamantes;
    }
}

public class MorrePet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet("", 0, 0, 0);
        
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                pet = new Pet(ui[1], Integer.parseInt(ui[2]), Integer.parseInt(ui[3]), Integer.parseInt(ui[4]));
            }else if(ui[0].equals("show")){
                System.out.println(pet);
            }else if(ui[0].equals("play")){
                pet.play();
            }else if(ui[0].equals("eat")){
                pet.eat();
            }else if(ui[0].equals("sleep")){
                pet.sleep();
            }else if(ui[0].equals("clean")){
                pet.clean();
            }else{
                System.out.println("Comando invalido!");
            }
        }
    }
    
}
