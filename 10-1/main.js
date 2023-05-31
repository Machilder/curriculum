
//console.log(10 + 8);


let numbers = [2, 5, 12, 13, 15, 18, 22];

//ここに答えを実装してください。↓↓↓
for (let i = 0; i < numbers.length; i++) {
    //console.log(numbers[i]);
    if (numbers[i]%2===0){
        isEven(numbers[i]);
    }
}

function isEven(num) {
    console.log(num + 'は偶数です');
}

class Car {

    //コンストラクタ
    constructor(Gass,Number) {
        this.Gass = Gass;
        this.Number = Number;
    }

    //歩くメソッド（関数）作成
    getNumGas() {
        console.log(`ガソリンは${this.Gass}です。ナンバーは${this.Number}です`);
    }
}


let clsCar = new Car('regular',22222);
clsCar.getNumGas();