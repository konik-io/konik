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
package io.konik.validation;

import static java.math.RoundingMode.HALF_UP;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.entity.AllowanceCharge;
import io.konik.zugferd.entity.GrossPrice;
import io.konik.zugferd.entity.trade.MonetarySummation;
import io.konik.zugferd.entity.trade.item.Item;
import io.konik.zugferd.entity.trade.item.ItemTax;
import io.konik.zugferd.entity.trade.item.SpecifiedMonetarySummation;
import io.konik.zugferd.unqualified.Amount;
import io.konik.zugferd.unqualified.Quantity;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import com.neovisionaries.i18n.CurrencyCode;

/**
 *  Calculate the missing amounts of the invoice.
 */
public class AmountCalculator {

   private Invoice doc;
   private CurrencyCode defaultCurrency;
   
   AmountCalculator (Invoice doc){
      this.doc = doc;
      this.defaultCurrency = doc.getTrade().getSettlement().getMonetarySummation().getGrandTotal().getCurrency();
   }
   
   public BigDecimal total(Invoice doc) {
      return null;
   }

 
   public MonetarySummation monetarySummation() {
      MonetarySummation monetarySummation = new MonetarySummation();
      
      BigDecimal total = BigDecimal.ZERO;
      BigDecimal allowanceTotal = BigDecimal.ZERO;
      
      List<Item> items = doc.getTrade().getItems();
      for (Item item : items) {
         SpecifiedMonetarySummation lineMonetarySummation = lineMonetarySummation(item);
         total = total.add(lineMonetarySummation.getLineTotal().getValue());
         allowanceTotal = allowanceTotal.add(lineMonetarySummation.getTotalAllowanceCharge().getValue());         
      }
      monetarySummation.setLineTotal(new Amount(total, defaultCurrency));
      
      return monetarySummation;
   }
   
   /**
    * Line monetary summation.
    * 
    * The line total amount is the net amount, including any additions and deductions without specifying the value-added tax.
    *
    * @param item the item
    * @return the specified monetary summation
    */
   public SpecifiedMonetarySummation lineMonetarySummation(Item item) {
      SpecifiedMonetarySummation monetarySummation = new SpecifiedMonetarySummation();
      CurrencyCode currency = getCurrency(item);
      
      monetarySummation.setLineTotal(new Amount(lineTotalAmount(item),currency));

      BigDecimal lineTotalAllowanceCharge = lineTotalAllowanceCharge(item.getAgreement().getGrossPrice());
      monetarySummation.setTotalAllowanceCharge(new Amount(lineTotalAllowanceCharge, currency));
      return monetarySummation;
   }

   private CurrencyCode getCurrency(Item item) {
      return item.getAgreement().getGrossPrice().getChargeAmount().getCurrency();
   }
   
   public BigDecimal lineTotalAmount(Item item){
      BigDecimal lineNetTotalAmount = lineNetTotalAmount(item);      
      BigDecimal lineNetTotalTaxAmount = lineNetTotalTaxAmount(item);
      return lineNetTotalAmount.add(lineNetTotalTaxAmount);
   }
   
   /**
    * Line net total tax amount
    * 
    * line Net * VAT[] = TotalLineAmount
    *
    * @param item the item
    * @return the big decimal
    */
   public BigDecimal lineNetTotalTaxAmount(Item item){
      BigDecimal lineNetTotalAmount = lineNetTotalAmount(item);
      List<ItemTax> tradeTax = item.getSettlement().getTradeTax();
      for (ItemTax tax : tradeTax) {
         lineNetTotalAmount = lineNetTotalAmount.multiply(tax.getPercentage().divide(new BigDecimal(100),HALF_UP));
      }
      return lineNetTotalAmount;
   }
   
   
   
   /**
    * Calculate line net total amount.
    * 
    * net price * billedQuantity = line net total amount
    *
    * @param item the item
    * @return the big decimal
    */
   public BigDecimal lineNetTotalAmount(Item item) {
      BigDecimal lineNetAmount = calcLineNetAmount(item.getAgreement().getGrossPrice());
      Quantity billed = item.getDelivery().getBilled();
      BigDecimal lineTotalAmount = lineNetAmount.multiply(billed.getValue());
      return lineTotalAmount;
   }
   
   /**
    * Calculate the line net amount.
    * 
    *  gross price + surcharges - discounts = net price
    *
    * @param grossPrice the gross price
    * @return the big decimal
    */
   public BigDecimal calcLineNetAmount(GrossPrice grossPrice) {
      BigDecimal grossPriceAmount = grossPrice.getChargeAmount().getValue();
      BigDecimal lineAllowanceTotalAmount = lineTotalAllowanceCharge(grossPrice);
      return grossPriceAmount.add(lineAllowanceTotalAmount);
   }


   private BigDecimal lineTotalAllowanceCharge(GrossPrice grossPrice) {
      BigDecimal lineNetAmount = BigDecimal.ZERO;
      for (AllowanceCharge allowanceCharge : grossPrice.getAllowanceCharges()) {
         if (allowanceCharge.isSurcharge()) {
            lineNetAmount = lineNetAmount.add(allowanceCharge.getActual().getValue());
         }else {
            lineNetAmount = lineNetAmount.subtract(allowanceCharge.getActual().getValue());
         }
      }
      return lineNetAmount;
   }
     
   public BigDecimal lineTotalIncVat(Item item) {
      
      //Settlement
      SpecifiedMonetarySummation monetarySummation = item.getSettlement().getMonetarySummation();
      List<ItemTax> tradeTax = item.getSettlement().getTradeTax();


      
      //gross price
      GrossPrice grossPrice = item.getAgreement().getGrossPrice();
      List<AllowanceCharge> allowanceCharges = grossPrice.getAllowanceCharges();
      Quantity basisQuantity = grossPrice.getBasis();
      Amount chargeAmount = grossPrice.getChargeAmount();
      
      
      
      return null;
      //1 TB100A4 Trennblätter A4 20 Stk. 9,90 198,00 19%
   }
}
/*
      <ram:IncludedSupplyChainTradeLineItem>
         <ram:AssociatedDocumentLineDocument>
            <ram:LineID>1</ram:LineID>
         </ram:AssociatedDocumentLineDocument>
         <ram:SpecifiedSupplyChainTradeAgreement>
            <ram:GrossPriceProductTradePrice>
               <ram:ChargeAmount currencyID="EUR">9.9000</ram:ChargeAmount>
            </ram:GrossPriceProductTradePrice>
            <ram:NetPriceProductTradePrice>
               <ram:ChargeAmount currencyID="EUR">9.9000</ram:ChargeAmount>
            </ram:NetPriceProductTradePrice>
         </ram:SpecifiedSupplyChainTradeAgreement>
         <ram:SpecifiedSupplyChainTradeDelivery>
            <ram:BilledQuantity unitCode="C62">20.0000</ram:BilledQuantity>
         </ram:SpecifiedSupplyChainTradeDelivery>
         <ram:SpecifiedSupplyChainTradeSettlement>
            <ram:ApplicableTradeTax>
               <ram:TypeCode>VAT</ram:TypeCode>
               <ram:CategoryCode>S</ram:CategoryCode>
               <ram:ApplicablePercent>19.00</ram:ApplicablePercent>
            </ram:ApplicableTradeTax>
            <ram:SpecifiedTradeSettlementMonetarySummation>
               <ram:LineTotalAmount currencyID="EUR">198.00</ram:LineTotalAmount>
            </ram:SpecifiedTradeSettlementMonetarySummation>
         </ram:SpecifiedSupplyChainTradeSettlement>
         <ram:SpecifiedTradeProduct>
            <ram:GlobalID schemeID="0160">4012345001235</ram:GlobalID>
            <ram:SellerAssignedID>TB100A4</ram:SellerAssignedID>
            <ram:Name>Trennblätter A4</ram:Name>
         </ram:SpecifiedTradeProduct>
      </ram:IncludedSupplyChainTradeLineItem>
*/