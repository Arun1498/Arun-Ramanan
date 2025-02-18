var o = 1
const n1 = 10
const n2=5
 Operation = () => {
    switch (o) {
        case 1:
          result=add();
          break;
        case 2:
          result=sub();
          break;
        case 3:
          result=mul();
          break;
        case 4:
          result=div();
          break;
          default:
              console.log("Invalid operation");  
      }
  
}
add=()=>n1+n2;
sub=()=>n1-n2;
mul=()=>n1*n2;
div=()=>n1/n2;
Operation();
console.log(result)
    