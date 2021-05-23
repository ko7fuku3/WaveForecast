package ejb;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class WaveForecastEJB {
	
	public WaveForecastEJB() {
	}

	
	public ArrayList<String> waveForecast(HttpServletRequest request) {

		ArrayList<String> expectedResultList = new ArrayList<>();
		
		// 風向
		String windDirection = request.getParameter("windDirection");
		// うねりの向き
		String swellDirection = request.getParameter("swellDirection");
		// 風速
		String windSpeedStr = request.getParameter("windSpeed");
		int windSpeed = Integer.parseInt(windSpeedStr);
		// 波高
		String waveSizeStr = request.getParameter("waveSize");
		double waveSize = Double.parseDouble(waveSizeStr);
		
		// 波のサイズ予想
		expectedResultList.add(sizeForecast(waveSize));

		// 波のコンディション予想
		expectedResultList.add("◎");
		
		return expectedResultList;
	}
	
	/**
	 * 波のサイズ予想
	 * @return 波のサイズ
	 */
	private String sizeForecast(double waveSize) {
		
		String resultSize = "";
		
		// 0.3ｍなら膝
		if (0 <= waveSize && waveSize >= 0.3) {
			resultSize = "膝";
		// 0.6ｍなら腰
		} else if (0.3 < waveSize && waveSize >= 0.6) {
			resultSize = "腰";
		// 0.9ｍなら腹
		} else if (0.6 < waveSize && waveSize >= 0.9) {
			resultSize = "腹";
		// 1.2ｍなら胸
		} else if (0.9 < waveSize && waveSize >= 1.2) {
			resultSize = "胸";
		// 1.5ｍなら肩
		} else if (1.2 < waveSize && waveSize >= 1.5) {
			resultSize = "肩";
		// 1.8ｍなら頭
		} else if (1.5 < waveSize && waveSize >= 1.8) {
			resultSize = "頭";
		// 2.0ｍならオーバーヘッド
		} else if (1.8 < waveSize && waveSize >= 2.0) {
			resultSize = "オーバーヘッド";
		}

		return resultSize;
	}
}
