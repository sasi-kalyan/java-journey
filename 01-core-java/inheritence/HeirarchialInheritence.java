
class Alpha{
    int alpha = 10;
    public void methodAlpha(){
        System.out.println("Alpha method");
    }
}

class Beta extends Alpha{
    int beta = 10;
    public void methodBeta(){
        System.out.println("Beta method");
    }
}

class Gamma extends Alpha{
    int gamma = 10;
    public void methodGamma(){
        System.out.println("Gamma method");
    }
}

class Theta extends Alpha{
    int theta = 10;
    public void methodTheta(){
        System.out.println("Theta method");
    }
}

public class HeirarchialInheritence {
    public static void main(String[] args) {
        Beta betaObj = new Beta();
        System.out.println("alpha : "+betaObj.alpha);
        System.out.println("beta : "+betaObj.beta);
        betaObj.methodAlpha();
        betaObj.methodBeta();

        Gamma gammaObj = new Gamma();
        System.out.println("alpha : "+gammaObj.alpha);
        System.out.println("gamma : "+gammaObj.gamma);
        gammaObj.methodAlpha();
        gammaObj.methodGamma();

        Theta thetaObj = new Theta();
        System.out.println("alpha : "+thetaObj.alpha);
        System.out.println("theta : "+thetaObj.theta);
        thetaObj.methodAlpha();
        thetaObj.methodTheta();

    }
}
