public class RomanNumerials {
    public static void main(String[] args){
        final int DIVISOR = 10;
        int tens = 1000;
        int fives = 500;

        String ten = "M";
        String five = "D";

        int num = 3998;

        String answer = "";

        while(num > 0 && tens >= 1){
            if(num/tens < 4) {
                ten = getNumerial(tens);
                answer+=append(num, tens, ten);
                num-=(num/tens) * tens;
            }

            if(num/(tens-(tens/10)) == 1) {
                answer += getNumerial(tens - (tens / 10));
                System.out.println(answer);
                num-=(num/(tens-(tens/10))) * tens-(tens/10);
            }

            if(fives > 0){
                five = getNumerial(fives);
                answer+=append(num, fives, five);
                num-=(num/fives)*fives;
            }

            if((fives > 0) && num/(fives - (fives/5))  == 1){
                answer += getNumerial(fives - (tens/10));
                num-=(num/(fives - (tens/10)))*(fives - (tens/10));
            }

            if(tens == 10)
                System.out.println("here " + fives);
            tens /=DIVISOR;
            fives /=DIVISOR;
        }

        System.out.println(answer);
    }

    static String append(int num, int divisor, String s ){
        String app = "";
        for(int i = 0;i < (num/divisor); i++)
            app+=s;
        return app;
    }

    static String getNumerial(int check){
        String num = "";
        switch (check){
            case 1: case 4: case 9:
                num += 'I';
                break;
            case 5:
                num += 'V';
                break;
            case 10: case 40: case 90:
                num += 'X';
                break;
            case 50:
                num += 'L';
                break;
            case 100: case 400: case 900:
                num += 'C';
                break;
            case 500:
                num += 'D';
                break;
            case 1000:
                num += 'M';
                break;
        }

        switch (check){
            case 4:
                num += 'V';
                break;
            case 9:
                num += 'X';
                break;
            case 40:
                num += 'L';
                break;
            case 90:
                num += 'C';
                break;
            case 400:
                num += 'D';
                break;
            case 900:
                num += 'M';
                break;
        }

        return (num + " ");
    }

}
