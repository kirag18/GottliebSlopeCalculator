public class LinearEquation {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private boolean und;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        und = x1 == x2;
    }

    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2)));
    }

    public double yIntercept(){
        return roundedToHundredth(y1 - slope()*x1);
    }

    public double slope(){
        return roundedToHundredth((y2-y1)/(x2-x1));
    }

    public String equation(){
        if (y2==y1){
            return ("y = "+ (int)y1);
        } else if (!und){
            double slope = (y2-y1)/(x2-x1);
            String equation = "y = ";
            if (slope % 1 == 0){
                if (slope == -1){
                    equation += "-x";
                } else if (slope != 1) {
                    equation += (int)slope + "x";
                } else{
                    equation += "x";
                }
            }else{
                if (slope < 0){
                    equation += "-";
                }
                equation += (int)(Math.abs(y2-y1))+"/"+(int)(Math.abs(x2-x1)) + "x";
            }
            double yInt = yIntercept();
            if (yInt<0){
                equation += " - " + Math.abs(yInt);
            } else if (yInt > 0) {
                equation += " + " + Math.abs(yInt);
            }
            return equation;
        }else {
            return "x = " + (int)x1;
        }
    }

    public String coordinateForX(double x){
        x = roundedToHundredth(x);
        return ("("+x+", "+(roundedToHundredth(x*slope() + yIntercept()))+")");
    }

    public String lineInfo(){
        String info = "The two points are: ";
        info += "("+(int)x1+ ", "+ (int) y1+")"+ " and " + "("+(int)x2+ ", "+ (int) y2+")\n";
        info += "The equations of the line between these points is: " + equation();
        info += "\nThe slope of this line is: ";
        if (und){
            info += "undefined";
        }else{
            info += slope();
        }
        info += "\nThe y-intercept of this line is: ";
        if (und && x1==0){
            info += "all y values";
        }else if (und){
            info += "no values";
        }else{
            info += yIntercept();
        }
        info += "\nThe distance between these points is " + distance();
        return info;
    }


    private double roundedToHundredth(double toRound){
        return Math.round(100*toRound)/100.0;
    }
}
