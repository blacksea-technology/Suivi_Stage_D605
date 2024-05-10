package com.suivistage.api.exception;

public enum ErrorCodes {
	AFFECTATION_NON_TROUVEE(110),
	LIEU_NON_TROUVE(120),
	STAGIAIRE_NON_TROUVE(130),
	SUIVI_NON_TROUVE(140),
	SUJET_NON_TROUVE(150),
	TUTEUR_NON_TROUVE(160),
	UTILISATEUR_NON_TROUVE(170);
	
	private int code;
	
	ErrorCodes(int code) {
		this.code=code;
	}
	public int getCode() {
		return this.code;
	}
}
