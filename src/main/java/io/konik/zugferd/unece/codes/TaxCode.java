/* Copyright (C) 2014 konik.io
 *
 * This file is part of the Konik library.
 *
 * The Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * The Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the Konik library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.unece.codes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * = Tax Code
 * 
 * Code specifying a type of duty, tax or fee.
 * 
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred5153.htm[UN/EDIFACT 5153 Duty or tax or fee type name code]
 */
@XmlType(name = "TaxTypeCodeType")
@XmlEnum
public enum TaxCode {

   /**
    * A tax levied on the volume of petroleum being
    * transacted.
    */
   AAA("Petroleum tax"),
   /**
    * Countervailing duty paid in cash prior to a formal
    * finding of subsidization by Customs.
    */
   AAB("Provisional countervailing duty cash"),
   /**
    * Countervailing duty paid by posting a bond during an
    * investigation period prior to a formal decision on
    * subsidization by Customs.
    */
   AAC("Provisional countervailing duty bond"),
   /**
    * A tax levied on tobacco products.
    */
   AAD("Tobacco tax"),
   /**
    * General fee or tax for the use of energy.
    */
   AAE("Energy fee"),
   /**
    * A tax levied specifically on coffee products.
    */
   AAF("Coffee tax"),
   /**
    * A harmonized sales tax consisting of a goods and service
    * tax, a Canadian provincial sales tax and, as applicable,
    * a Quebec sales tax which is recoverable.
    */
   AAG("Harmonised sales tax, Canadian"),
   /**
    * A sales tax charged within the Canadian province of
    * Quebec which is recoverable.
    */
   AAH("Quebec sales tax"),
   /**
    * A sales tax charged within Canadian provinces which is
    * non-recoverable.
    */
   AAI("Canadian provincial sales tax"),
   /**
    * A tax levied on a replacement part, where the original
    * part is returned.
    */
   AAJ("Tax on replacement part"),
   /**
    * Tax that is levied specifically on products containing
    * mineral oil.
    */
   AAK("Mineral oil tax"),
   /**
    * To indicate a special type of tax.
    */
   AAL("Special tax"),
   /**
    * Duty applied to goods ruled to have been dumped in an
    * import market at a price lower than that in the
    * exporter's domestic market.
    */
   ADD("Anti-dumping duty"),
   /**
    * Tax required in Italy, which may be fixed or graduated
    * in various circumstances (e.g. VAT exempt documents or
    * bank receipts).
    */
   BOL("Stamp duty (Imposta di Bollo)"),
   /**
    * Levy imposed on agricultural products where there is a
    * difference between the selling price between trading
    * countries.
    */
   CAP("Agricultural levy"),
   /**
    * A tax that is levied on the value of the automobile.
    */
   CAR("Car tax"),
   /**
    * Italian Paper consortium tax.
    */
   COC("Paper consortium tax (Italy)"),
   /**
    * Tax related to a specified commodity, e.g. illuminants,
    * salts.
    */
   CST("Commodity specific tax"),
   /**
    * Duties laid down in the Customs tariff, to which goods
    * are liable on entering or leaving the Customs territory
    * (CCC).
    */
   CUD("Customs duty"),
   /**
    * A duty on imported goods applied for compensate for
    * subsidies granted to those goods in the exporting
    * country.
    */
   CVD("Countervailing duty"),
   /**
    * Tax assessed for funding or assuring environmental
    * protection or clean-up.
    */
   ENV("Environmental tax"),
   /**
    * Customs or fiscal authorities code to identify a
    * specific or ad valorem levy on a specific commodity,
    * applied either domestically or at time of importation.
    */
   EXC("Excise duty"),
   /**
    * Monetary rebate given to the seller in certain
    * circumstances when agricultural products are exported.
    */
   EXP("Agricultural export rebate"),
   /**
    * Tax levied by the federal government on the manufacture
    * of specific items.
    */
   FET("Federal excise tax"),
   /**
    * No tax levied.
    */
   FRE("Free"),
   /**
    * General tax for construction.
    */
   GCN("General construction tax"),
   /**
    * Tax levied on the final consumption of goods and
    * services throughout the production and distribution
    * chain.
    */
   GST("Goods and services tax"),
   /**
    * Tax of illuminants.
    */
   ILL("Illuminants tax"),
   /**
    * Tax assessed on imports.
    */
   IMP("Import tax"),
   /**
    * A tax levied based on an individual's ability to pay.
    */
   IND("Individual tax"),
   /**
    * Government assessed charge for permit to do business.
    */
   LAC("Business license fee"),
   /**
    * Local tax for construction.
    */
   LCN("Local construction tax"),
   /**
    * Fee levied on a vessel to pay for port navigation
    * lights.
    */
   LDP("Light dues payable"),
   /**
    * Assessment charges on sale of goods or services by city,
    * borough country or other taxing authorities below state
    * or provincial level.
    */
   LOC("Local sales tax"),
   /**
    * Tax imposed for clean-up of leaky underground storage
    * tanks.
    */
   LST("Lust tax"),
   /**
    * Levy on Common Agricultural Policy (European Union)
    * goods used to compensate for fluctuating currencies
    * between member states.
    */
   MCA("Monetary compensatory amount"),
   /**
    * Duty paid and held on deposit, by Customs, during an
    * investigation period prior to a final decision being
    * made on any aspect related to imported goods (except
    * valuation) by Customs.
    */
   MCD("Miscellaneous cash deposit"),
   /**
    * Unspecified, miscellaneous tax charges.
    */
   OTH("Other taxes"),
   /**
    * Anti-dumping duty paid by posting a bond during an
    * investigation period prior to a formal decision on
    * dumping by Customs.
    */
   PDB("Provisional duty bond"),
   /**
    * Anti-dumping duty paid in cash prior to a formal finding
    * of dumping by Customs.
    */
   PDC("Provisional duty cash"),
   /**
    * Duties laid down in the Customs tariff, to which goods
    * are liable on entering or leaving the Customs territory
    * falling under a preferential regime such as Generalised
    * System of Preferences (GSP).
    */
   PRF("Preference duty"),
   /**
    * Special tax for construction.
    */
   SCN("Special construction tax"),
   /**
    * Social securities share of the invoice amount to be paid
    * directly to the social securities collector.
    */
   SSS("Shifted social securities"),
   /**
    * All applicable sale taxes by authorities at the state or
    * provincial level, below national level.
    */
   STT("State/provincial sales tax"),
   /**
    * Duty suspended or deferred from payment.
    */
   SUP("Suspended duty"),
   /**
    * A tax or duty applied on and in addition to existing
    * duties and taxes.
    */
   SUR("Surtax"),
   /**
    * Wage tax share of the invoice amount to be paid directly
    * to the tax collector(s office).
    */
   SWT("Shifted wage tax"),
   /**
    * A tax levied based on the type of alcohol being
    * obtained.
    */
   TAC("Alcohol mark tax"),
   /**
    * The summary amount of all taxes.
    */
   TOT("Total"),
   /**
    * Tax levied on the total sales/turnover of a corporation.
    */
   TOX("Turnover tax"),
   /**
    * Tax levied based on the vessel's net tonnage.
    */
   TTA("Tonnage taxes"),
   /**
    * Duty paid and held on deposit, by Customs, during an
    * investigation period prior to a formal decision on
    * valuation of the goods being made.
    */
   VAD("Valuation deposit"),
   /**
    * A tax on domestic or imported goods applied to the value
    * added at each stage in the production/distribution
    * cycle.
    */
   VAT("Value added tax"),

   /** The zf insurance tax, which is temporary */
   ZF_INSURANCE_TAX("Insurance Tax");

   /** The description for the tax code */
   private final String description;

   private TaxCode(String description) {
      this.description = description;
   }

   /**
    * Gets the code.
    *
    * @return the code
    */
   public String getCode() {
      return name();
   }

   /**
    * Gets the description.
    *
    * @return the description
    */
   public String getDescription() {
      return description;
   }

   /**
    * Gets the type by code.
    *
    * @param description the enum code
    * @return the type by code or {@link IllegalArgumentException}
    */
   public static TaxCode getByCode(String description) {
      return valueOf(description);
   }

   @Override
   public String toString() {
      return new StringBuilder().append("[").append(getCode()).append("] ").append(description).toString();
   }
}
