package com.wipro.holmes.uhg.enb.esp.specs.gsf.v1_3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Fields {

	RELATIONSHIP("Relationship", "A"), EMPLOYEE_ID("Employee ID", "B"), EMPLOYMENT_DATE("Employment Date", "C"),
	LAST_NAME("Last Name", "D"), FIRST_NAME("First Name", "E"), MIDDLE_INITIAL("Middle Initial", "F"),
	DATE_OF_BIRTH("Date of Birth", "G"), GENDER("Gender", "H"), MARITAL_STATUS("Marital Status", "I"),
	PERMANENT_STREET_1("Permanent Street 1", "J"), PERMANENT_STREET_2("Permanent Street 2", "K"),
	PERMANENT_CITY("Permanent City", "L"), PERMANENT_STATE_ABBREVIATION("Permanent State Abbreviation", "M"),
	PERMANENT_ZIP("Permanent Zip", "N"), PERMANENT_COUNTRY_CODE("Permanent Country Code", "O"),
	MEMBER_SSN("Member SSN", "P"), FORMER_EEID("Former EEID", "Q"), PERSONNEL_ID("Personnel ID", "R"),
	MAILING_STREET_1("Mailing Street 1", "S"), MAILING_STREET_2("Mailing Street 2", "T"),
	MAILING_CITY("Mailing City", "U"), MAILING_STATE_ABBREVIATION("Mailing State Abbreviation", "V"),
	MAILING_ZIP("Mailing Zip", "W"), MAILING_COUNTRY_CODE("Mailing Country Code", "X"), COB_FLAG("COB Flag", "Y"),
	COB_START_DATE("COB Start Date", "Z"), COB_STOP_DATE("COB Stop Date", "AA"), CUSTODY_CODE("Custody Code", "AB"),
	LANGUAGE("Language", "AC"), PHONE_NUMBER("Phone Number", "AD"), DEATH_DATE("Death Date", "AE"),
	XREF_PAYEE_INDICATOR_Y("XREF/Payee Indicator (Y)", "AF"), XREF_PAYEE_LAST_NAME("XREF/Payee Last Name", "AG"),
	XREF_PAYEE_FIRST_NAME("XREF/Payee First Name", "AH"), XREF_PAYEE_SSN("XREF/Payee SSN", "AI"),
	SPECIAL_UTIL_4("Special Util 4", "AJ"), SUB_DEPT_NUMBER("Sub-Dept Number", "AK"), RETIRE_DATE("Retire Date", "AL"),
	PCP_MPIN("PCP MPIN", "AM"), PCP_LOCATION_CODE("PCP Location Code", "AN"), PCP_START_DATE("PCP Start Date", "AO"),
	PCP_STOP_DATE("PCP Stop Date", "AP"), PCP_IPA("PCP IPA", "AQ"), PCP_CPI("PCP CPI", "AR"),
	PCD_MPIN("PCD MPIN", "AS"), PCD_START_DATE("PCD Start Date", "AT"), PCD_STOP_DATE("PCD Stop Date", "AU"),
	PCD_IPA("PCD IPA", "AV"), PCD_CPI("PCD CPI", "AW"), MEDICARE_TYPE("Medicare Type", "AX"),
	MEDICARE_A_START_DATE("Medicare A Start Date", "AY"), MEDICARE_A_STOP_DATE("Medicare A Stop Date", "AZ"),
	MEDICARE_B_START_DATE("Medicare B Start Date", "BA"), MEDICARE_B_STOP_DATE("Medicare B Stop Date", "BB"),
	MEDICARE_D_START_DATE("Medicare D Start Date", "BC"), MEDICARE_D_STOP_DATE("Medicare D Stop Date", "BD"),
	INELIGIBLE_INDICATOR("Ineligible Indicator", "BE"), ENTITLEMENT_REASON_CODE("Entitlement Reason Code", "BF"),
	AFFIRMATION_INDICATOR("Affirmation Indicator", "BG"), ELECTRONIC_SIGNATURE("Electronic Signature", "BH"),
	EMAIL_ADDRESS("Email Address", "BI"), DOCUMENT_PREFERENCE_INDICATOR("Document Preference Indicator", "BJ"),
	SPEC_UTIL_2("Spec Util 2", "BK"), SPEC_UTIL_3("Spec Util 3", "BL"), FUTURE_USE_1("Future Use 1", "BM"),
	SALARY("Salary", "BN"), EIN("EIN", "BO"), EIN_EFFECTIVE_DATE("EIN Effective Date", "BP"),
	EIN_END_DATE("EIN End Date", "BQ"), FUTURE_USE_2("Future Use 2", "BR"), COMMON_UTILITY_1("Common Utility 1", "BS"),
	COMMON_UTILITY_2("Common Utility 2", "BT"), MEMBER_UTILITY_1("Member Utility 1", "BU"),
	SPEC_UTIL_1("Spec Util 1", "BV"), COVERAGE_1_TYPE("Coverage 1 Type", "BW"),
	COVERAGE_1_START_DATE("Coverage 1 Start Date", "BX"), COVERAGE_1_END_DATE("Coverage 1 End Date", "BY"),
	COVERAGE_1_PAID_THRU_DATE("Coverage 1 Paid Thru Date", "BZ"),
	COVERAGE_1_CUSTOMER_NUMBER("Coverage 1 Customer Number", "CA"),
	COVERAGE_1_POLICY_NUMBER("Coverage 1 Policy Number", "CB"),
	COVERAGE_1_PLAN_VARIATION_CODE("Coverage 1 Plan Variation Code", "CC"),
	COVERAGE_1_REPORTING_CODE("Coverage 1 Reporting Code", "CD"),
	COVERAGE_1_STRUCTURE_FIELD_5_PLAN_CODE("Coverage 1 Structure Field 5 (Plan Code)", "CE"),
	COVERAGE_1_STRUCTURE_FIELD_6("Coverage 1 Structure Field 6", "CF"),
	COVERAGE_1_STRUCTURE_FIELD_7("Coverage 1 Structure Field 7", "CG"),
	COVERAGE_1_STRUCTURE_FIELD_8("Coverage 1 Structure Field 8", "CH"),
	COVERAGE_1_SUPP_LIFE_AMT("Coverage 1 Supp Life Amt", "CI"),
	COVERAGE_1_SUPP_LIFE_BEN_FACTOR("Coverage 1 Supp Life Ben Factor", "CJ"),
	COVERAGE_1_SUPP_AD_D_AMT("Coverage 1 Supp AD&D Amt", "CK"),
	COVERAGE_1_SUPP_AD_D_BEN_FACTOR("Coverage 1 Supp AD&D Ben Factor", "CL"),
	COVERAGE_1_EVIDENCE_OF_INSURABILITY_FOR_LIFE("Coverage 1 Evidence of Insurability for Life", "CM"),
	COVERAGE_1_MEMBERS_COVERED("Coverage 1 Members Covered", "CN"),
	COVERAGE_1_COBRA_INDICATOR_CANCEL_REASON("Coverage 1 Cobra Indicator/Cancel Reason", "CO"),
	COVERAGE_1_ELIG_UTIL_1("Coverage 1 Elig Util-1", "CP"), COVERAGE_1_ELIG_UTIL_2("Coverage 1 Elig Util-2", "CQ"),
	COVERAGE_1_ELIG_UTIL_3("Coverage 1 Elig Util-3", "CR"),
	COVERAGE_1_ELIG_LONG_UTIL_1("Coverage 1 Elig Long Util-1", "CS"),
	COVERAGE_1_LIFE_FLAT_AMT("Coverage 1 Life Flat Amt", "CT"),
	COVERAGE_1_LIFE_BEN_FACTOR("Coverage 1 Life Ben Factor", "CU"),
	COVERAGE_1_LIFE_COV_STATUS("Coverage 1 Life Cov Status", "CV"),
	COVERAGE_1_RIDER_DEP_FLAG("Coverage 1 Rider Dep Flag", "CW"),
	COVERAGE_1_RIDER_CRITICAL_ILLNESS("Coverage 1 Rider Critical Illness", "CX"),
	COVERAGE_2_TYPE("Coverage 2 Type", "CY"), COVERAGE_2_START_DATE("Coverage 2 Start Date", "CZ"),
	COVERAGE_2_END_DATE("Coverage 2 End Date", "DA"), COVERAGE_2_PAID_THRU_DATE("Coverage 2 Paid Thru Date", "DB"),
	COVERAGE_2_CUSTOMER_NUMBER("Coverage 2 Customer Number", "DC"),
	COVERAGE_2_POLICY_NUMBER("Coverage 2 Policy Number", "DD"),
	COVERAGE_2_PLAN_VARIATION_CODE("Coverage 2 Plan Variation Code", "DE"),
	COVERAGE_2_REPORTING_CODE("Coverage 2 Reporting Code", "DF"),
	COVERAGE_2_STRUCTURE_FIELD_5_PLAN_CODE("Coverage 2 Structure Field 5 (Plan Code)", "DG"),
	COVERAGE_2_STRUCTURE_FIELD_6("Coverage 2 Structure Field 6", "DH"),
	COVERAGE_2_STRUCTURE_FIELD_7("Coverage 2 Structure Field 7", "DI"),
	COVERAGE_2_STRUCTURE_FIELD_8("Coverage 2 Structure Field 8", "DJ"),
	COVERAGE_2_SUPP_LIFE_AMT("Coverage 2 Supp Life Amt", "DK"),
	COVERAGE_2_SUPP_LIFE_BEN_FACTOR("Coverage 2 Supp Life Ben Factor", "DL"),
	COVERAGE_2_SUPP_AD_D_AMT("Coverage 2 Supp AD&D Amt", "DM"),
	COVERAGE_2_SUPP_AD_D_BEN_FACTOR("Coverage 2 Supp AD&D Ben Factor", "DN"),
	COVERAGE_2_EVIDENCE_OF_INSURABILITY_FOR_LIFE("Coverage 2 Evidence of Insurability for Life", "DO"),
	COVERAGE_2_MEMBERS_COVERED("Coverage 2 Members Covered", "DP"),
	COVERAGE_2_COBRA_INDICATOR_CANCEL_REASON("Coverage 2 Cobra Indicator/Cancel Reason", "DQ"),
	COVERAGE_2_ELIG_UTIL_1("Coverage 2 Elig Util-1", "DR"), COVERAGE_2_ELIG_UTIL_2("Coverage 2 Elig Util-2", "DS"),
	COVERAGE_2_ELIG_UTIL_3("Coverage 2 Elig Util-3", "DT"),
	COVERAGE_2_ELIG_LONG_UTIL_1("Coverage 2 Elig Long Util-1", "DU"),
	COVERAGE_2_LIFE_FLAT_AMT("Coverage 2 Life Flat Amt", "DV"),
	COVERAGE_2_LIFE_BEN_FACTOR("Coverage 2 Life Ben Factor", "DW"),
	COVERAGE_2_LIFE_COV_STATUS("Coverage 2 Life Cov Status", "DX"),
	COVERAGE_2_RIDER_DEP_FLAG("Coverage 2 Rider Dep Flag", "DY"),
	COVERAGE_2_RIDER_CRITICAL_ILLNESS("Coverage 2 Rider Critical Illness", "DZ"),
	COVERAGE_3_TYPE("Coverage 3 Type", "EA"), COVERAGE_3_START_DATE("Coverage 3 Start Date", "EB"),
	COVERAGE_3_END_DATE("Coverage 3 End Date", "EC"), COVERAGE_3_PAID_THRU_DATE("Coverage 3 Paid Thru Date", "ED"),
	COVERAGE_3_CUSTOMER_NUMBER("Coverage 3 Customer Number", "EE"),
	COVERAGE_3_POLICY_NUMBER("Coverage 3 Policy Number", "EF"),
	COVERAGE_3_PLAN_VARIATION_CODE("Coverage 3 Plan Variation Code", "EG"),
	COVERAGE_3_REPORTING_CODE("Coverage 3 Reporting Code", "EH"),
	COVERAGE_3_STRUCTURE_FIELD_5_PLAN_CODE("Coverage 3 Structure Field 5 (Plan Code)", "EI"),
	COVERAGE_3_STRUCTURE_FIELD_6("Coverage 3 Structure Field 6", "EJ"),
	COVERAGE_3_STRUCTURE_FIELD_7("Coverage 3 Structure Field 7", "EK"),
	COVERAGE_3_STRUCTURE_FIELD_8("Coverage 3 Structure Field 8", "EL"),
	COVERAGE_3_SUPP_LIFE_AMT("Coverage 3 Supp Life Amt", "EM"),
	COVERAGE_3_SUPP_LIFE_BEN_FACTOR("Coverage 3 Supp Life Ben Factor", "EN"),
	COVERAGE_3_SUPP_AD_D_AMT("Coverage 3 Supp AD&D Amt", "EO"),
	COVERAGE_3_SUPP_AD_D_BEN_FACTOR("Coverage 3 Supp AD&D Ben Factor", "EP"),
	COVERAGE_3_EVIDENCE_OF_INSURABILITY_FOR_LIFE("Coverage 3 Evidence of Insurability for Life", "EQ"),
	COVERAGE_3_MEMBERS_COVERED("Coverage 3 Members Covered", "ER"),
	COVERAGE_3_COBRA_INDICATOR_CANCEL_REASON("Coverage 3 Cobra Indicator/Cancel Reason", "ES"),
	COVERAGE_3_ELIG_UTIL_1("Coverage 3 Elig Util-1", "ET"), COVERAGE_3_ELIG_UTIL_2("Coverage 3 Elig Util-2", "EU"),
	COVERAGE_3_ELIG_UTIL_3("Coverage 3 Elig Util-3", "EV"),
	COVERAGE_3_ELIG_LONG_UTIL_1("Coverage 3 Elig Long Util-1", "EW"),
	COVERAGE_3_LIFE_FLAT_AMT("Coverage 3 Life Flat Amt", "EX"),
	COVERAGE_3_LIFE_BEN_FACTOR("Coverage 3 Life Ben Factor", "EY"),
	COVERAGE_3_LIFE_COV_STATUS("Coverage 3 Life Cov Status", "EZ"),
	COVERAGE_3_RIDER_DEP_FLAG("Coverage 3 Rider Dep Flag", "FA"),
	COVERAGE_3_RIDER_CRITICAL_ILLNESS("Coverage 3 Rider Critical Illness", "FB"),
	COVERAGE_4_TYPE("Coverage 4 Type", "FC"), COVERAGE_4_START_DATE("Coverage 4 Start Date", "FD"),
	COVERAGE_4_END_DATE("Coverage 4 End Date", "FE"), COVERAGE_4_PAID_THRU_DATE("Coverage 4 Paid Thru Date", "FF"),
	COVERAGE_4_CUSTOMER_NUMBER("Coverage 4 Customer Number", "FG"),
	COVERAGE_4_POLICY_NUMBER("Coverage 4 Policy Number", "FH"),
	COVERAGE_4_PLAN_VARIATION_CODE("Coverage 4 Plan Variation Code", "FI"),
	COVERAGE_4_REPORTING_CODE("Coverage 4 Reporting Code", "FJ"),
	COVERAGE_4_STRUCTURE_FIELD_5_PLAN_CODE("Coverage 4 Structure Field 5 (Plan Code)", "FK"),
	COVERAGE_4_STRUCTURE_FIELD_6("Coverage 4 Structure Field 6", "FL"),
	COVERAGE_4_STRUCTURE_FIELD_7("Coverage 4 Structure Field 7", "FM"),
	COVERAGE_4_STRUCTURE_FIELD_8("Coverage 4 Structure Field 8", "FN"),
	COVERAGE_4_SUPP_LIFE_AMT("Coverage 4 Supp Life Amt", "FO"),
	COVERAGE_4_SUPP_LIFE_BEN_FACTOR("Coverage 4 Supp Life Ben Factor", "FP"),
	COVERAGE_4_SUPP_AD_D_AMT("Coverage 4 Supp AD&D Amt", "FQ"),
	COVERAGE_4_SUPP_AD_D_BEN_FACTOR("Coverage 4 Supp AD&D Ben Factor", "FR"),
	COVERAGE_4_EVIDENCE_OF_INSURABILITY_FOR_LIFE("Coverage 4 Evidence of Insurability for Life", "FS"),
	COVERAGE_4_MEMBERS_COVERED("Coverage 4 Members Covered", "FT"),
	COVERAGE_4_COBRA_INDICATOR_CANCEL_REASON("Coverage 4 Cobra Indicator/Cancel Reason", "FU"),
	COVERAGE_4_ELIG_UTIL_1("Coverage 4 Elig Util-1", "FV"), COVERAGE_4_ELIG_UTIL_2("Coverage 4 Elig Util-2", "FW"),
	COVERAGE_4_ELIG_UTIL_3("Coverage 4 Elig Util-3", "FX"),
	COVERAGE_4_ELIG_LONG_UTIL_1("Coverage 4 Elig Long Util-1", "FY"),
	COVERAGE_4_LIFE_FLAT_AMT("Coverage 4 Life Flat Amt", "FZ"),
	COVERAGE_4_LIFE_BEN_FACTOR("Coverage 4 Life Ben Factor", "GA"),
	COVERAGE_4_LIFE_COV_STATUS("Coverage 4 Life Cov Status", "GB"),
	COVERAGE_4_RIDER_DEP_FLAG("Coverage 4 Rider Dep Flag", "GC"),
	COVERAGE_4_RIDER_CRITICAL_ILLNESS("Coverage 4 Rider Critical Illness", "GD"),
	COVERAGE_5_TYPE("Coverage 5 Type", "GE"), COVERAGE_5_START_DATE("Coverage 5 Start Date", "GF"),
	COVERAGE_5_END_DATE("Coverage 5 End Date", "GG"), COVERAGE_5_PAID_THRU_DATE("Coverage 5 Paid Thru Date", "GH"),
	COVERAGE_5_CUSTOMER_NUMBER("Coverage 5 Customer Number", "GI"),
	COVERAGE_5_POLICY_NUMBER("Coverage 5 Policy Number", "GJ"),
	COVERAGE_5_PLAN_VARIATION_CODE("Coverage 5 Plan Variation Code", "GK"),
	COVERAGE_5_REPORTING_CODE("Coverage 5 Reporting Code", "GL"),
	COVERAGE_5_STRUCTURE_FIELD_5_PLAN_CODE("Coverage 5 Structure Field 5 (Plan Code)", "GM"),
	COVERAGE_5_STRUCTURE_FIELD_6("Coverage 5 Structure Field 6", "GN"),
	COVERAGE_5_STRUCTURE_FIELD_7("Coverage 5 Structure Field 7", "GO"),
	COVERAGE_5_STRUCTURE_FIELD_8("Coverage 5 Structure Field 8", "GP"),
	COVERAGE_5_SUPP_LIFE_AMT("Coverage 5 Supp Life Amt", "GQ"),
	COVERAGE_5_SUPP_LIFE_BEN_FACTOR("Coverage 5 Supp Life Ben Factor", "GR"),
	COVERAGE_5_SUPP_AD_D_AMT("Coverage 5 Supp AD&D Amt", "GS"),
	COVERAGE_5_SUPP_AD_D_BEN_FACTOR("Coverage 5 Supp AD&D Ben Factor", "GT"),
	COVERAGE_5_EVIDENCE_OF_INSURABILITY_FOR_LIFE("Coverage 5 Evidence of Insurability for Life", "GU"),
	COVERAGE_5_MEMBERS_COVERED("Coverage 5 Members Covered", "GV"),
	COVERAGE_5_COBRA_INDICATOR_CANCEL_REASON("Coverage 5 Cobra Indicator/Cancel Reason", "GW"),
	COVERAGE_5_ELIG_UTIL_1("Coverage 5 Elig Util-1", "GX"), COVERAGE_5_ELIG_UTIL_2("Coverage 5 Elig Util-2", "GY"),
	COVERAGE_5_ELIG_UTIL_3("Coverage 5 Elig Util-3", "GZ"),
	COVERAGE_5_ELIG_LONG_UTIL_1("Coverage 5 Elig Long Util-1", "HA"),
	COVERAGE_5_LIFE_FLAT_AMT("Coverage 5 Life Flat Amt", "HB"),
	COVERAGE_5_LIFE_BEN_FACTOR("Coverage 5 Life Ben Factor", "HC"),
	COVERAGE_5_LIFE_COV_STATUS("Coverage 5 Life Cov Status", "HD"),
	COVERAGE_5_RIDER_DEP_FLAG("Coverage 5 Rider Dep Flag", "HE"),
	COVERAGE_5_RIDER_CRITICAL_ILLNESS("Coverage 5 Rider Critical Illness", "HF");

	private String field;
	private String column;

	public String toString() {
		return field;

	}

}