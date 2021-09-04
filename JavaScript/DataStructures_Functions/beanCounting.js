function countChar(Str, ch) {
    let count = 0;    
    for (let i = 0; i < Str.length; i++) {
        if (Str[i] == ch) count++;
    }
    return count
}

console.log(countChar("kakkerlak", "k"));