class Carro:
    def __init__(self):
        self.passageiro = 0
        self.km = 0
        self.gasolina = 0
        self.passagMax = 2
        self.gasMax = 10
        
    def entrar(self):
        if self.passageiro < self.passagMax:
            self.passageiro += 1
        else:
            print("Falha: limite de pessoas atingido!")
            
    def sair(self):
        if self.passageiro > 0:
            self.passageiro -= 1
        else:
            print("Falha: não a ninguem no carro!")
    
    def abastecer(self, quantgas):
        self.gasolina += quantgas
        if(self.gasolina > self.gasMax):
            self.gasolina = self.gasMax
    
    def andar(self, distancia):
        if self.passageiro == 0:
            print("Falha: não a ninguem no carro!")
            return
        gasneed = distancia / 10
        if(self.gasolina >= gasneed):
            self.km += distancia
            self.gasolina -= gasneed
        else:
            print("Falha: gasolina insuficiente!")
        
    def __str__(self):
        return "passa: " + str(self.passageiro) + ", gasolina: " + str(self.gasolina) + ", km: " + str(self.km)

carro = Carro()
line = ""
print("Digite: show, in, out, abast _quant, andar _dist ou end")
while(line != "end"):
    line = input()
    ui = line.split(" ")
    if ui[0] == "end":
        break
    elif ui[0] == "show":
        print(carro)
    elif ui[0] == "in":
        carro.entrar()
    elif ui[0] == "out":
        carro.sair()
    elif ui[0] == "abast":
        carro.abastecer(int(ui[1]))
    elif ui[0] == "andar":
        carro.andar(int(ui[1]))
    else:
        print("Falha: comando inalido!")
        
