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
package io.konik.zugferd.entity;

import io.konik.jaxb.adapter.TradeDeliveryTermsAdapter;
import io.konik.zugferd.entity.trade.Agreement;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * = The Agreement
 * 
 * This base agreement class contain only fields. {@link CommonAgreement} and {@link Agreement} provide a different view on the underlying Data,
 * we have this common field structure class because otherwise we would have two +SupplyChainTradeAgreementType+s and this is not allowed in JaxB
 * @param <REF> the different Referenced Document
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "SupplyChainTradeAgreementType", propOrder = { "buyerReference", "seller", "buyer","productEndUser","deliveryTerms",
		"buyerOrder", "contract", "additional", "grossPrice", "netPrice", "customerOrder" })
//@XmlSeeAlso({Agreement.class,SpecifiedAgreement.class})
public abstract class CommonAgreement<REF extends ReferencedDocument> {

	@XmlElement(name = "BuyerReference")
	protected String buyerReference;// in trade.agreement only

	@Valid
	@XmlElement(name = "SellerTradeParty")
	protected TradeParty seller;// in trade.agreement only

	@Valid
	@XmlElement(name = "BuyerTradeParty")
	protected TradeParty buyer;// in trade.agreement only

	@Valid
	@XmlElement(name = "ProductEndUserTradeParty")
   protected TradeParty productEndUser;// in trade.agreement only

	@Valid
	@XmlElement(name = "ApplicableTradeDeliveryTerms")
	@XmlJavaTypeAdapter(value = TradeDeliveryTermsAdapter.class)
   protected String deliveryTerms;// in trade.agreement only
   
	@Valid
	@XmlElement(name = "BuyerOrderReferencedDocument",type=ReferencedDocument.class)
	protected REF buyerOrder;// trade.agreement(IssueDateTime, ID) + item.agreement(LineID)

	@Valid
	@XmlElement(name = "ContractReferencedDocument", type=ReferencedDocument.class)// trade.agreement(IssueDateTime, ID) + item.agreement(LineID)
	protected REF contract;

	@Valid
	@XmlElement(name = "AdditionalReferencedDocument", type=ReferencedDocument.class)
   protected List<REF> additional;// trade.agreement(IssueDateTime, TypeCode, ID) != item.agreement(IssueDateTime,LineID,ID,ReferenceTypeCode)

	@Valid
	@XmlElement(name = "GrossPriceProductTradePrice")
	protected GrossPrice grossPrice;// in item.agreement only

	@Valid
	@XmlElement(name = "NetPriceProductTradePrice")
	protected Price netPrice;// in item.agreement only

	@Valid
	@XmlElement(name = "CustomerOrderReferencedDocument", type=ReferencedDocument.class)
	protected REF customerOrder;//trade.agreement (IssueDateTime, ID) + item.agreement(LineID)

	/**
	 * Gets the buyer order referenced document.
	 *
	 * @return the buyer order referenced document
	 */
	public abstract REF getBuyerOrder();

   /**
	 * Sets the buyer order referenced document.
	 *
	 * @param buyerOrder the new buyer order referenced document
	 * @return the supply chain trade agreement
	 */
	public abstract CommonAgreement<REF> setBuyerOrder(REF buyerOrder);

	/**
	 * Gets the contract referenced document.
	 * 
	 * Profile:: COMFORT 
	 *
	 * @return the contract referenced document
	 */
	public abstract  REF getContract();

	/**
	 * Sets the contract referenced document.
	 * 
	 * Profile:: COMFORT 
	 *
	 * @param contract the new contract referenced document
	 * @return the supply chain trade agreement
	 */
	public abstract  CommonAgreement<REF> setContract(REF contract);

	/**
    * Gets the additional referenced document
    *
    * @return the additional
    */
	public abstract List<REF> getAdditional();
	

   /**
    * Sets the additional referenced document.
    *
    * @param additionalReference the additional reference
    * @return the common agreement
    */
   public abstract CommonAgreement<REF> addAdditional(REF additionalReference);
   

   /**
	 * Gets the customer order referenced document.
	 * 
	 * Profile:: COMFORT 
	 *
	 * @return the customer order referenced document
	 */
	public abstract  REF getCustomerOrder();

	/**
	 * Sets the customer order referenced document.
	 *  
	 * Profile:: COMFORT 
	 *
	 * @param customerOrder the new customer order referenced document
	 * @return the supply chain trade agreement
	 */
	public abstract  CommonAgreement<REF> setCustomerOrder(REF customerOrder);

}
