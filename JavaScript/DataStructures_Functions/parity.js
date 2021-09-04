function Parity(num) {
    if (num == 0) {
        return "is even"
    }
    if (num == 1) {
        return "is odd"
    }
    return Parity(num-2)
}

console.log(Parity(12))