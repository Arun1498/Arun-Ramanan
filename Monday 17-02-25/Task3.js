function Digisum(n){
    let s=0;
    n = Math.abs(n);
    while(n>0){
        s += n % 10;
        n = Math.floor(n / 10);
        
    }
    if (s % 2 === 0) {
        return 'Even';
      } else {
        return 'Odd';
      }
    }
    console.log(Digisum(34));
    console.log(Digisum(33));
