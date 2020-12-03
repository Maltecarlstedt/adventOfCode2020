inputPuzzle = open("input1.1.txt")
data = inputPuzzle.read()
listOfInputPuzzle = [int(i) for i in data.split("\n")[:-1]]
inputPuzzle.close()


for i in range(len(listOfInputPuzzle)-2):
    for j in range(i+1, len(listOfInputPuzzle)):
        for k in range(j+2, len(listOfInputPuzzle)):
            if listOfInputPuzzle[i] + listOfInputPuzzle[j] + listOfInputPuzzle[k] == 2020:
                answer = listOfInputPuzzle[i] * listOfInputPuzzle[j] * listOfInputPuzzle[k]
                print(answer)