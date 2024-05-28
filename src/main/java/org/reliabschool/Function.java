package org.reliabschool;

import static java.lang.Math.*;

public class Function {

    public double f1(double x, double b, double a) {
        if (x <= 3) {
            return b + 2 * log(abs(x));
        } else {
            return pow(x, 2) / (pow(x, 2) + a);
        }
    }

    public double f2(double x, double b, double a) {
        if (x > 0) {
            return a + 0.5 * exp(-x);
        } else {
            return cos(b * x + 1);
        }
    }

    public double f3(double x, double b, double a) {
        if (x <= 1) {
            return 1 / (pow(a, 2) + pow(x, 2));
        } else {
            return b * log(abs(x));
        }
    }

    public double f4(double x, double b, double a) {
        if (x <= 2) {
            return (a + pow(x, 2)) / (b + log(abs(x) + 1));
        } else {
            return exp(x) + pow(x, 2);
        }
    }

    public double f5(double x, double b, double a) {
        if (x <= 1) {
            return a * pow(sin(x), 2) + sqrt(x);
        } else {
            return b * exp(pow(x, 2));
        }
    }

    public double f6(double x, double b, double a) {
        if (x <= -1) {
            return a * tan(pow(x, 2));
        } else {
            return b + pow(x, 2) / (pow(x, 2) + a);
        }
    }

    public double f7(double x, double b, double a) {
        if (x > 3) {
            return (a + x) * atan(a * x);
        } else {
            return pow(cos(b + pow(x, 3)), 2);
        }
    }

    public double f8(double x, double b, double a) {
        if (x < 5) {
            return pow(sin(a + x), 3);
        } else {
            return log(sqrt(abs(b - x)));
        }
    }

    public double f9(double x, double b, double a) {
        if (x >= 2) {
            return sqrt(1 + x * sqrt(a * x));
        } else {
            return a * sin(b * x) + 3;
        }
    }

    public double f10(double x, double b, double a) {
        if (x <= 0) {
            return sqrt(exp(2 * x - b)) - 1;
        } else {
            return 1 / (pow(x, 2) + a);
        }
    }

    public double f11(double x, double b, double a) {
        if (x > 4) {
            return sqrt(a + abs(sin(x)));
        } else {
            return tan(b * x);
        }
    }

    public double f12(double x, double b, double a) {
        if (x <= 1) {
            return 2 * pow(x, 2) + a * cos(b * x);
        } else {
            return exp(x) + tan(pow(x, 3));
        }
    }

    public double f13(double x, double b, double a) {
        if (x >= 2) {
            return log(a + pow(x, 2));
        } else {
            return exp(sin(x)) + 2 * b;
        }
    }

    public double f14(double x, double b, double a) {
        if (x > -1) {
            return 0.2 * pow(x, 3) + a;
        } else {
            return b * pow(x, 2) + log(abs(x + 3));
        }
    }

    public double f15(double x, double b, double a) {
        if (x < 2) {
            return sin(x + pow(a, 2));
        } else {
            return log(pow(x, 2) + 2 * x + b);
        }
    }

    public double f16(double x, double b, double a) {
        if (x < 2) {
            return cos(x + pow(a, 2));
        } else {
            return log(pow(x, 2) + 2 * x + b);
        }
    }
}
