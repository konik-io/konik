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

import javax.xml.bind.annotation.XmlType;

/**
 * = The Tax Category Code.
 *
 * Based on 5305  Duty or tax or fee category code
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred5305.htm[UN/EDIFACT 5305  Duty or tax or fee category code^]
 * 
 */
@XmlType(name = "TaxCategoryCodeType")
public enum TaxCategory {

   /**
    * Mixed tax rate
    * 
    * Code specifying that the rate is based on mixed tax.
    **/
   A("Mixed tax rate", "Code specifying that the rate is based on mixed tax."),

   /**
    * Lower rate
    * 
    * Tax rate is lower than standard rate.
    **/
   AA("Lower rate", "Tax rate is lower than standard rate."),

   /**
    * Exempt for resale
    * 
    * A tax category code indicating the item is tax exempt
    * when the item is bought for future resale.
    **/
   AB("Exempt for resale", "A tax category code indicating the item is tax exempt when the item is bought for future resale."),

   /**
    * Value Added Tax (VAT) not now due for payment
    * 
    * A code to indicate that the Value Added Tax (VAT) amount
    * which is due on the current invoice is to be paid on
    * receipt of a separate VAT payment request.
    **/
   AC("Value Added Tax (VAT) not now due for payment"," A code to indicate that the Value Added Tax (VAT) amount which is due on the current invoice is to be paid on receipt of a separate VAT payment request."),

   /**
    * Value Added Tax (VAT) due from a previous invoice
    * 
    * A code to indicate that the Value Added Tax (VAT) amount
    * of a previous invoice is to be paid.
    **/
   AD("Value Added Tax (VAT) due from a previous invoice","A code to indicate that the Value Added Tax (VAT) amount of a previous invoice is to be paid."),

   /**
    * VAT Reverse Charge
    * 
    * Code specifying that the standard VAT rate is levied
    * from the invoicee.
    **/
   AE("VAT Reverse Charge", "Code specifying that the standard VAT rate is levied from the invoicee."),

   /**
    * Transferred (VAT)
    * 
    * VAT not to be paid to the issuer of the invoice but
    * directly to relevant tax authority.
    **/
   B("Transferred (VAT)", "VAT not to be paid to the issuer of the invoice but directly to relevant tax authority."),

   /**
    * Duty paid by supplier
    * 
    * Duty associated with shipment of goods is paid by the
    * supplier; customer receives goods with duty paid.
    **/
   C("Duty paid by supplier","Duty associated with shipment of goods is paid by the supplier; customer receives goods with duty paid."),

   /**
    * Exempt from tax
    * 
    * Code specifying that taxes are not applicable.
    **/
   E("Exempt from tax", "Code specifying that taxes are not applicable."),

   /**
    * Free export item, tax not charged
    * 
    * Code specifying that the item is free export and taxes
    * are not charged.
    **/
   G("Free export item, tax not charged", "Code specifying that the item is free export and taxes are not charged."),

   /**
    * Higher rate
    * 
    * Code specifying a higher rate of duty or tax or fee.
    **/
   H("Higher rate", "Code specifying a higher rate of duty or tax or fee."),

   /**
    * Services outside scope of tax
    * 
    * Code specifying that taxes are not applicable to the
    * services.
    **/
   O("Services outside scope of tax", "Code specifying that taxes are not applicable to the services."),

   /**
    * Standard rate
    * 
    * Code specifying the standard rate.
    **/
   S("Standard rate", "Code specifying the standard rate."),

   /**
    * Zero rated goods
    * 
    * Code specifying that the goods are at a zero rate.
    **/
   Z("Zero rated goods", "Code specifying that the goods are at a zero rate.");

   private final String description;

   private final String detailedDescription;

   private TaxCategory(String description, String detailedDescription) {
      this.description = description;
      this.detailedDescription = detailedDescription;
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
    * Gets the detailed description.
    *
    * @return the detailed description
    */
   public String getDetailedDescription() {
      return detailedDescription;
   }

   /**
    * Retrieves a TaxCategoryCode the by the given code.
    *
    * @param code the code
    * @return the by code
    */
   public static TaxCategory getByCode(String code){
      return valueOf(code);
   }
   
   @Override
   public String toString() {
      return new StringBuilder().append("[").append(getCode()).append("] ").append(description).toString();
   }

}
