class Pet:
    def __init__(self, energia, saciedade, limpeza):
        self.energia = energia
        self.saciedade = saciedade
        self.limpeza = limpeza
        self.energiaMax = energia
        self.saciedadeMax = saciedade
        self.limpezaMax = limpeza
        
    def __str__(self):
        return "E: " + str(self.energia) + "/" + str(self.energiaMax) + \
              " S: " + str(self.saciedade) + "/" + str(self.saciedadeMax) + \
              " L: " + str(self.limpeza) + "/" + str(self.limpezaMax)

pet = Pet(0, 0, 0)
print("Digite: end, init E S L, show")
while True:
    ui = input().split(" ")
    if ui[0] == "end":
        break
    elif ui[0] == "init":
        pet = Pet(int(ui[1]), int(ui[2]), int(ui[3]))
    elif ui[0] == "show":
        print(pet)
    else:
        print("Falha: comando ivalido!")