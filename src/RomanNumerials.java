public class RomanNumerials {
    public static void main(String[] args){
        final int DIVISOR = 10;
        int tens = 1000;
        int fives = 500;

        char ten = 'M';
        char five = 'D';

        int num = 3998;

        String answer = "";

        while(num > 0 && tens >= 1){
            if(num/tens < 4) {
                ten = getNumerial(tens);
                answer+=append(num, tens, ten);
                num-=(num/tens) * tens;
            }

            if(num/(tens-(tens/10)) == 1) {
                answer += getNumerial(tens / 10);
                answer += getNumerial(tens) + " ";
                System.out.println(answer);
                num-=(num/(tens-(tens/10))) * tens-(tens/10);
            }

            if(fives > 0){
                five = getNumerial(fives);
                answer+=append(num, fives, five);
                num-=(num/fives)*fives;
            }

            if((fives > 0) && num/(fives - (fives/5))  == 1){
                answer += getNumerial(fives/5);
                answer += getNumerial(fives) + " ";
                num-=(num/(fives - (tens/10)))*(fives - (tens/10));
            }

            if(tens == 10)
                System.out.println("here " + fives);
            tens /=DIVISOR;
            fives /=DIVISOR;
        }

        System.out.println(answer);
    }

    static String append(int num, int divisor, char c ){
        String app = "";
        for(int i = 0;i < (num/divisor); i++)
            app+=c + " ";
        return app;
    }

    static char getNumerial(int check){
        String num = "";
        switch (check){
            case 1:
                return 'I';
            case 5:
                return 'V';
            case 10:
                return 'X';
            case 50:
                return 'L';
            case 100:
                return 'C';
            case 500:
                return 'D';
            case 1000:
                return 'M';
        }
        return 'e';
    }

}
