
/*
进水水质要求：
	PH=6~9; BOD/COD>0.3;
	有脱氮要求：BOD/TN>4.0; 总碱度（以CaCO3计）/氨氮>3.6；
	对水质污染物去除率（初步沉淀+SBR）：
	悬浮物：70-90
	BOD5: 80-95
	COD: 80-90
	氨氮： 85-95
	TN: 60-85
	TP: 50-85
*/
class SBR {
    int Q = 10;    //输入每个周期水量
    int S = 300;    //输入每个周期水量进水五日生化需氧量BOD5（mg/L）
    int SS = 50;    //输入每个周期水量进水悬浮物SS（mg/L）
    double SSrate = 0.9;    //SS浓度减少比率
    double L = 0.13;    //反应池的五日生化需氧量污泥负荷kgBOD5/（kgMLSS·d）
    int X = 5;    //反应池内混合液悬浮固体（MLSS）平均浓度kgMLSS/m3
    double T;    //每个周期反应时间
    double m = 0.35;    //充水比（周期进水量与反应池体积比例）
    int SVI;    //输入SVI
    double Y = 0.4;    //污泥产率系数
    int HRT = 24;    //水力停留时间设为24h
    int GasWater = 4;    //气水比设为4
    double State1 = 0.8;    //好氧阶段占用比例
    double State2 = 0.2;    //厌氧阶段占用比例
    int V = 20;    //反应器体积

    public void timeCaculate() {
        int t1 = 0;    //进水时间为0
        int t3 = 1;    //沉淀时间为1
        int t4 = 1;    //排水时间为1
        double t2;    //反应时间
        t2 = 24 * m * S * 0.95 / 1000 / L / X;
        double t = t1 + t2 + t3 + t4;
        T = t;
        System.out.println("T1=" + t1 + " " + "T2=" + t2 + " " + "T3=" + t3 + " " + "T4=" + t4 + "   " + "T=" + T);
    }


    public void sludgeCaculate() {
        double sludge = Y * Q * S * 0.95 * 24 / T - 0.05 * V * X + 0.6 * Q * SSrate * 24 / T;
        System.out.println("Sludge=" + sludge);
    }


    public static void main(String[] args) {
        SBR S = new SBR();
        S.timeCaculate();
        S.sludgeCaculate();
    }
}
