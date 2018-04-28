package server.view;

import server.model.DetectionModel;

public class DetectionViewHelper {
	private DetectionModel detectionModel;

	/**
	 * resets all eye expression data to false
	 */
	public void resetEye() {
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setBlink(false);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setWinkLeft(false);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setWinkRight(false);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setLookLeft(false);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setLookRight(false);
	}

	/**
	 * resets all lowerface expression data to 0
	 */
	public void resetLowerface() {
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setSmile(0);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setClench(0);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setSmirkLeft(0);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setSmirkRight(0);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setLaugh(0);
	}

	/**
	 * resets all upperface expression data to 0
	 */
	public void resetUpperface() {
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setRaiseBrow(0);
		detectionModel.getPrimaryDataModel().getExpressiveDataModel().setFurrowBrow(0);
	}

	/**
	 * resets all performance Metrics expression data to 0
	 */
	public void resetPerformanceMetrics() {
		detectionModel.getPrimaryDataModel().getAffectiveDataModel().setInterest(0);
		detectionModel.getPrimaryDataModel().getAffectiveDataModel().setEngagement(0);
		detectionModel.getPrimaryDataModel().getAffectiveDataModel().setStress(0);
		detectionModel.getPrimaryDataModel().getAffectiveDataModel().setRelaxation(0);
		detectionModel.getPrimaryDataModel().getAffectiveDataModel().setRelaxation(0);
		detectionModel.getPrimaryDataModel().getAffectiveDataModel().setExcitement(0);
	}
}
