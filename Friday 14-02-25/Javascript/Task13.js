let firstNo = 7;
let secondNo = 20;
let thirdNo = secondNo + 40;

while (secondNo <= thirdNo) {
  if (secondNo % firstNo === 0) {
    console.log(secondNo);
  }
  secondNo++;
}
