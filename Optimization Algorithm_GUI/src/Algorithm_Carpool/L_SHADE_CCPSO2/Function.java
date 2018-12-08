package Algorithm_Carpool.L_SHADE_CCPSO2;

public class Function extends L_SHADE_CCPSO2{

	static void Update_Alpha() {

		if (SAlpha1.size() > 0 && SAlpha2.size() > 0 && SAlpha3.size()>0) {
			double totalsum = 0;
			double meanwSAlpha1 = 0,meanwSAlpha2 = 0,meanwSAlpha3 = 0;
			for (int i = 0; i < SAlpha1.size(); i++)
				totalsum += ferc.get(i);
			for (int i = 0; i < SAlpha1.size(); i++) {
				double w = ferc.get(i) / totalsum;
				meanwSAlpha1 += w * SAlpha1.get(i);
				meanwSAlpha2 += w * SAlpha2.get(i);
				meanwSAlpha3 += w * SAlpha3.get(i);
			}
			MAlpha1[k11] = meanwSAlpha1;
			MAlpha2[k11] = meanwSAlpha2;
			MAlpha3[k11] = meanwSAlpha3;
		}
		k11++;
		if (k11 >= H)
			k11 = 0;

	}

}
