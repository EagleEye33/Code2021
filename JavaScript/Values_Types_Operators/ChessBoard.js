let boardSize = 8
for(i = 1; i <= boardSize; i+=1) {
    if (i % 2 == 1) {
        console.log("# ".repeat(boardSize/2));
    }
    else if (i % 2 == 0){
        console.log(" #".repeat(boardSize/2));
    }
}