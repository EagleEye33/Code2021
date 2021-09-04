function speak(line) {
    console.log(`The ${this.type} rabbit says '${line}'`);
  }
  var whiteRabbit = {type: "white", speak};
  var hungryRabbit = {type: "hungry", speak};
  
  
  var Rabbit = class Rabbit {
    constructor(type) {
      this.type = type;
    }
    speak(line) {
      console.log(`The ${this.type} rabbit says '${line}'`);
    }
  }
  
  var killerRabbit = new Rabbit("killer");
  var blackRabbit = new Rabbit("black");
  
  Rabbit.prototype.toString = function() {
    return `a ${this.type} rabbit`;
  };

Rabbit.prototype.teeth = "small";
console.log(killerRabbit.teeth);
// → small
killerRabbit.teeth = "long, sharp, and bloody";
console.log(killerRabbit.teeth);
// → long, sharp, and bloody
console.log(blackRabbit.teeth);
// → small
console.log(Rabbit.prototype.teeth);
// → small
