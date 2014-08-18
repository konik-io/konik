/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.zugferd.unece.codes;

import static io.konik.util.Strings.isNullOrEmpty;

/**
 * = The Reference code qualifier
 * 
 * Code qualifying a reference.
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred1153.htm[UN/EDIFACT 1153  Reference code qualifier]
 */
public enum Reference {
   /**
    * Order acknowledgement document identifier
    * 
    * [1018] Reference number identifying the acknowledgement
    * of an order.
    **/
   AAA("Order acknowledgement document identifier"),

   /**
    * Proforma invoice document identifier
    * 
    * [1088] Reference number to identify a proforma invoice.
    **/
   AAB("Proforma invoice document identifier"),

   /**
    * Documentary credit identifier
    * 
    * [1172] Reference number to identify a documentary
    * credit.
    **/
   AAC("Documentary credit identifier"),

   /**
    * Contract document addendum identifier
    * 
    * [1318] Reference number to identify an addendum to a
    * contract.
    **/
   AAD("Contract document addendum identifier"),

   /**
    * Goods declaration number
    * 
    * Reference number assigned to a goods declaration.
    **/
   AAE("Goods declaration number"),

   /**
    * Debit card number
    * 
    * A reference number identifying a debit card.
    **/
   AAF("Debit card number"),

   /**
    * Offer number
    * 
    * (1332) Reference number assigned by issuing party to an
    * offer.
    **/
   AAG("Offer number"),

   /**
    * Bank's batch interbank transaction reference number
    * 
    * Reference number allocated by the bank to a batch of
    * different underlying interbank transactions.
    **/
   AAH("Bank's batch interbank transaction reference number"),

   /**
    * Bank's individual interbank transaction reference number
    * 
    * Reference number allocated by the bank to one specific
    * interbank transaction.
    **/
   AAI("Bank's individual interbank transaction reference number"),

   /**
    * Delivery order number
    * 
    * Reference number assigned by issuer to a delivery order.
    **/
   AAJ("Delivery order number"),

   /**
    * Despatch advice number
    * 
    * [1035] Reference number assigned by issuing party to a
    * despatch advice.
    **/
   AAK("Despatch advice number"),

   /**
    * Drawing number
    * 
    * Reference number identifying a specific product drawing.
    **/
   AAL("Drawing number"),

   /**
    * Waybill number
    * 
    * Reference number assigned to a waybill, see: 1001 = 700.
    **/
   AAM("Waybill number"),

   /**
    * Delivery schedule number
    * 
    * Reference number assigned by buyer to a delivery
    * schedule.
    **/
   AAN("Delivery schedule number"),

   /**
    * Consignment identifier, consignee assigned
    * 
    * [1362] Reference number assigned by the consignee to
    * identify a particular consignment.
    **/
   AAO("Consignment identifier, consignee assigned"),

   /**
    * Partial shipment identifier
    * 
    * [1310] Identifier of a shipment which is part of an
    * order.
    **/
   AAP("Partial shipment identifier"),

   /**
    * Transport equipment identifier
    * 
    * [8260] To identify a piece if transport equipment e.g.
    * container or unit load device.
    **/
   AAQ("Transport equipment identifier"),

   /**
    * Municipality assigned business registry number
    * 
    * A reference number assigned by a municipality to
    * identify a business.
    **/
   AAR("Municipality assigned business registry number"),

   /**
    * Transport contract document identifier
    * 
    * [1188] Reference number to identify a document
    * evidencing a transport contract.
    **/
   AAS("Transport contract document identifier"),

   /**
    * Master label number
    * 
    * Identifies the master label number of any package type.
    **/
   AAT("Master label number"),

   /**
    * Despatch note document identifier
    * 
    * [1128] Reference number to identify a Despatch Note.
    **/
   AAU("Despatch note document identifier"),

   /**
    * Enquiry number
    * 
    * Reference number assigned to an enquiry.
    **/
   AAV("Enquiry number"),

   /**
    * Docket number
    * 
    * A reference number identifying the docket.
    **/
   AAW("Docket number"),

   /**
    * Civil action number
    * 
    * A reference number identifying the civil action.
    **/
   AAX("Civil action number"),

   /**
    * Carrier's agent reference number
    * 
    * Reference number assigned by the carriers agent to a
    * transaction.
    **/
   AAY("Carrier's agent reference number"),

   /**
    * Standard Carrier Alpha Code (SCAC) number
    * 
    * For maritime shipments, this code qualifies a Standard
    * Alpha Carrier Code (SCAC) as issued by the United Stated
    * National Motor Traffic Association Inc.
    **/
   AAZ("Standard Carrier Alpha Code (SCAC) number"),

   /**
    * Customs valuation decision number
    * 
    * Reference by an importing party to a previous decision
    * made by a Customs administration regarding the valuation
    * of goods.
    **/
   ABA("Customs valuation decision number"),

   /**
    * End use authorization number
    * 
    * Reference issued by a Customs administration authorizing
    * a preferential rate of duty if a product is used for a
    * specified purpose, see: 1001 = 990.
    **/
   ABB("End use authorization number"),

   /**
    * Anti-dumping case number
    * 
    * Reference issued by a Customs administration pertaining
    * to a past or current investigation of goods "dumped" at
    * a price lower than the exporter's domestic market price.
    **/
   ABC("Anti-dumping case number"),

   /**
    * Customs tariff number
    * 
    * (7357) Code number of the goods in accordance with the
    * tariff nomenclature system of classification in use
    * where the Customs declaration is made.
    **/
   ABD("Customs tariff number"),

   /**
    * Declarant's reference number
    * 
    * Unique reference number assigned to a document or a
    * message by the declarant for identification purposes.
    **/
   ABE("Declarant's reference number"),

   /**
    * Repair estimate number
    * 
    * A number identifying a repair estimate.
    **/
   ABF("Repair estimate number"),

   /**
    * Customs decision request number
    * 
    * Reference issued by Customs pertaining to a pending
    * tariff classification decision requested by an importer
    * or agent.
    **/
   ABG("Customs decision request number"),

   /**
    * Sub-house bill of lading number
    * 
    * Reference assigned to a sub-house bill of lading.
    **/
   ABH("Sub-house bill of lading number"),

   /**
    * Tax payment identifier
    * 
    * [1168] Reference number identifying a payment of a duty
    * or tax e.g. under a transit procedure.
    **/
   ABI("Tax payment identifier"),

   /**
    * Quota number
    * 
    * Reference number allocated by a government authority to
    * identify a quota.
    **/
   ABJ("Quota number"),

   /**
    * Transit (onward carriage) guarantee (bond) number
    * 
    * Reference number to identify the guarantee or security
    * provided for Customs transit operation (CCC).
    **/
   ABK("Transit (onward carriage) guarantee (bond) number"),

   /**
    * Customs guarantee number
    * 
    * Reference assigned to a Customs guarantee.
    **/
   ABL("Customs guarantee number"),

   /**
    * Replacing part number
    * 
    * New part number which replaces the existing part number.
    **/
   ABM("Replacing part number"),

   /**
    * Seller's catalogue number
    * 
    * Identification number assigned to a seller's catalogue.
    **/
   ABN("Seller's catalogue number"),

   /**
    * Originator's reference
    * 
    * A unique reference assigned by the originator.
    **/
   ABO("Originator's reference"),

   /**
    * Declarant's Customs identity number
    * 
    * Reference to the party whose posted bond or security is
    * being declared in order to accept responsibility for a
    * goods declaration and the applicable duties and taxes.
    **/
   ABP("Declarant's Customs identity number"),

   /**
    * Importer reference number
    * 
    * Reference number assigned by the importer to identify a
    * particular shipment for his own purposes.
    **/
   ABQ("Importer reference number"),

   /**
    * Export clearance instruction reference number
    * 
    * Reference number of the clearance instructions given by
    * the consignor through different means.
    **/
   ABR("Export clearance instruction reference number"),

   /**
    * Import clearance instruction reference number
    * 
    * Reference number of the import clearance instructions
    * given by the consignor/consignee through different
    * means.
    **/
   ABS("Import clearance instruction reference number"),

   /**
    * Goods declaration document identifier, Customs
    * 
    * [1426] Reference number, assigned or accepted by
    * Customs, to identify a goods declaration.
    **/
   ABT("Goods declaration document identifier, Customs"),

   /**
    * Article number
    * 
    * A number that identifies an article.
    **/
   ABU("Article number"),

   /**
    * Intra-plant routing
    * 
    * To define routing within a plant.
    **/
   ABV("Intra-plant routing"),

   /**
    * Stock keeping unit number
    * 
    * A number that identifies the stock keeping unit.
    **/
   ABW("Stock keeping unit number"),

   /**
    * Text Element Identifier deletion reference
    * 
    * The reference used within a given TEI (Text Element
    * Identifier) which is to be deleted.
    **/
   ABX("Text Element Identifier deletion reference"),

   /**
    * Allotment identification (Air)
    * 
    * Reference assigned to guarantied capacity on one or more
    * specific flights on specific date(s) to third parties as
    * agents and other airlines.
    **/
   ABY("Allotment identification (Air)"),

   /**
    * Vehicle licence number
    * 
    * Number of the licence issued for a vehicle by an agency
    * of government.
    **/
   ABZ("Vehicle licence number"),

   /**
    * Air cargo transfer manifest
    * 
    * A number assigned to an air cargo list of goods to be
    * transferred.
    **/
   AC("Air cargo transfer manifest"),

   /**
    * Cargo acceptance order reference number
    * 
    * Reference assigned to the cargo acceptance order.
    **/
   ACA("Cargo acceptance order reference number"),

   /**
    * US government agency number
    * 
    * A number that identifies a United States Government
    * agency.
    **/
   ACB("US government agency number"),

   /**
    * Shipping unit identification
    * 
    * Identifying marks on the outermost unit that is used to
    * transport merchandise.
    **/
   ACC("Shipping unit identification"),

   /**
    * Additional reference number
    * 
    * [1010] Reference number provided in addition to another
    * given reference.
    **/
   ACD("Additional reference number"),

   /**
    * Related document number
    * 
    * Reference number identifying a related document.
    **/
   ACE("Related document number"),

   /**
    * Addressee reference
    * 
    * A reference number of an addressee.
    **/
   ACF("Addressee reference"),

   /**
    * ATA carnet number
    * 
    * Reference number assigned to an ATA carnet.
    **/
   ACG("ATA carnet number"),

   /**
    * Packaging unit identification
    * 
    * Identifying marks on packing units.
    **/
   ACH("Packaging unit identification"),

   /**
    * Outerpackaging unit identification
    * 
    * Identifying marks on packing units contained within an
    * outermost shipping unit.
    **/
   ACI("Outerpackaging unit identification"),

   /**
    * Customer material specification number
    * 
    * Number for a material specification given by customer.
    **/
   ACJ("Customer material specification number"),

   /**
    * Bank reference
    * 
    * Cross reference issued by financial institution.
    **/
   ACK("Bank reference"),

   /**
    * Principal reference number
    * 
    * A number that identifies the principal reference.
    **/
   ACL("Principal reference number"),

   /**
    * Collection advice document identifier
    * 
    * [1030] Reference number to identify a collection advice
    * document.
    **/
   ACN("Collection advice document identifier"),

   /**
    * Iron charge number
    * 
    * Number attributed to the iron charge for the production
    * of steel products.
    **/
   ACO("Iron charge number"),

   /**
    * Hot roll number
    * 
    * Number attributed to a hot roll coil.
    **/
   ACP("Hot roll number"),

   /**
    * Cold roll number
    * 
    * Number attributed to a cold roll coil.
    **/
   ACQ("Cold roll number"),

   /**
    * Railway wagon number
    * 
    * (8260) Registered identification initials and numbers of
    * railway wagon. Synonym: Rail car number.
    **/
   ACR("Railway wagon number"),

   /**
    * Unique claims reference number of the sender
    * 
    * A number that identifies the unique claims reference of
    * the sender.
    **/
   ACT("Unique claims reference number of the sender"),

   /**
    * Loss/event number
    * 
    * To reference to the unique number that is assigned to
    * each major loss hitting the reinsurance industry.
    **/
   ACU("Loss/event number"),

   /**
    * Estimate order reference number
    * 
    * Reference number assigned by the ordering party of the
    * estimate order.
    **/
   ACV("Estimate order reference number"),

   /**
    * Reference number to previous message
    * 
    * Reference number assigned to the message which was
    * previously issued (e.g. in the case of a cancellation,
    * the primary reference of the message to be cancelled
    * will be quoted in this element).
    **/
   ACW("Reference number to previous message"),

   /**
    * Banker's acceptance
    * 
    * Reference number for banker's acceptance issued by the
    * accepting financial institution.
    **/
   ACX("Banker's acceptance"),

   /**
    * Duty memo number
    * 
    * Reference number assigned by customs to a duty memo.
    **/
   ACY("Duty memo number"),

   /**
    * Equipment transport charge number
    * 
    * Reference assigned to a specific equipment
    * transportation charge.
    **/
   ACZ("Equipment transport charge number"),

   /**
    * Buyer's item number
    * 
    * [7304] Reference number assigned by the buyer to an
    * item.
    **/
   ADA("Buyer's item number"),

   /**
    * Matured certificate of deposit
    * 
    * Reference number for certificate of deposit allocated by
    * issuing financial institution.
    **/
   ADB("Matured certificate of deposit"),

   /**
    * Loan
    * 
    * Reference number for loan allocated by lending financial
    * institution.
    **/
   ADC("Loan"),

   /**
    * Analysis number/test number
    * 
    * Number given to a specific analysis or test operation.
    **/
   ADD("Analysis number/test number"),

   /**
    * Account number
    * 
    * Identification number of an account.
    **/
   ADE("Account number"),

   /**
    * Treaty number
    * 
    * A number that identifies a treaty.
    **/
   ADF("Treaty number"),

   /**
    * Catastrophe number
    * 
    * A number that identifies a catastrophe.
    **/
   ADG("Catastrophe number"),

   /**
    * Bureau signing (statement reference)
    * 
    * A statement reference that identifies a bureau signing.
    **/
   ADI("Bureau signing (statement reference)"),

   /**
    * Company / syndicate reference 1
    * 
    * First reference of a company/syndicate.
    **/
   ADJ("Company / syndicate reference 1"),

   /**
    * Company / syndicate reference 2
    * 
    * Second reference of a company/syndicate.
    **/
   ADK("Company / syndicate reference 2"),

   /**
    * Ordering customer consignment reference number
    * 
    * Reference number assigned to the consignment by the
    * ordering customer.
    **/
   ADL("Ordering customer consignment reference number"),

   /**
    * Shipowner's authorization number
    * 
    * Reference number assigned by the shipowner as an
    * authorization number to transport certain goods (such as
    * hazardous goods, cool or reefer goods).
    **/
   ADM("Shipowner's authorization number"),

   /**
    * Inland transport order number
    * 
    * Reference number assigned by the principal to the
    * transport order for inland carriage.
    **/
   ADN("Inland transport order number"),

   /**
    * Container work order reference number
    * 
    * Reference number assigned by the principal to the work
    * order for a (set of) container(s).
    **/
   ADO("Container work order reference number"),

   /**
    * Statement number
    * 
    * A reference number identifying a statement.
    **/
   ADP("Statement number"),

   /**
    * Unique market reference
    * 
    * A number that identifies a unique market.
    **/
   ADQ("Unique market reference"),

   /**
    * Group accounting
    * 
    * A number that identifies group accounting.
    **/
   ADT("Group accounting"),

   /**
    * Broker reference 1
    * 
    * First reference of a broker.
    **/
   ADU("Broker reference 1"),

   /**
    * Broker reference 2
    * 
    * Second reference of a broker.
    **/
   ADV("Broker reference 2"),

   /**
    * Lloyd's claims office reference
    * 
    * A number that identifies a Lloyd's claims office.
    **/
   ADW("Lloyd's claims office reference"),

   /**
    * Secure delivery terms and conditions agreement reference
    * 
    * A reference to a secure delivery terms and conditions
    * agreement. A secured delivery agreement is an agreement
    * containing terms and conditions to secure deliveries in
    * case of failure in the production or logistics process
    * of the supplier.
    **/
   ADX("Secure delivery terms and conditions agreement reference"),

   /**
    * Report number
    * 
    * Reference to a report to Customs by a carrier at the
    * point of entry, encompassing both conveyance and
    * consignment information.
    **/
   ADY("Report number"),

   /**
    * Trader account number
    * 
    * Number assigned by a Customs authority which uniquely
    * identifies a trader (i.e. importer, exporter or
    * declarant) for Customs purposes.
    **/
   ADZ("Trader account number"),

   /**
    * Authorization for expense (AFE) number
    * 
    * A number that identifies an authorization for expense
    * (AFE).
    **/
   AE("Authorization for expense (AFE) number"),

   /**
    * Government agency reference number
    * 
    * Coded reference number that pertains to the business of
    * a government agency.
    **/
   AEA("Government agency reference number"),

   /**
    * Assembly number
    * 
    * A number that identifies an assembly.
    **/
   AEB("Assembly number"),

   /**
    * Symbol number
    * 
    * A number that identifies a symbol.
    **/
   AEC("Symbol number"),

   /**
    * Commodity number
    * 
    * A number that identifies a commodity.
    **/
   AED("Commodity number"),

   /**
    * Eur 1 certificate number
    * 
    * Reference number assigned to a Eur 1 certificate.
    **/
   AEE("Eur 1 certificate number"),

   /**
    * Customer process specification number
    * 
    * Retrieval number for a process specification defined by
    * customer.
    **/
   AEF("Customer process specification number"),

   /**
    * Customer specification number
    * 
    * Retrieval number for a specification defined by
    * customer.
    **/
   AEG("Customer specification number"),

   /**
    * Applicable instructions or standards
    * 
    * Instructions or standards applicable for the whole
    * message or a message line item. These instructions or
    * standards may be published by a neutral organization or
    * authority or another party concerned.
    **/
   AEH("Applicable instructions or standards"),

   /**
    * Registration number of previous Customs declaration
    * 
    * Registration number of the Customs declaration lodged
    * for the previous Customs procedure.
    **/
   AEI("Registration number of previous Customs declaration"),

   /**
    * Post-entry reference
    * 
    * Reference to a message related to a post-entry.
    **/
   AEJ("Post-entry reference"),

   /**
    * Payment order number
    * 
    * A number that identifies a payment order.
    **/
   AEK("Payment order number"),

   /**
    * Delivery number (transport)
    * 
    * Reference number by which a haulier/carrier will
    * announce himself at the container terminal or depot when
    * delivering equipment.
    **/
   AEL("Delivery number (transport)"),

   /**
    * Transport route
    * 
    * A predefined and identified sequence of points where
    * goods are collected, agreed between partners, e.g. the
    * party in charge of organizing the transport and the
    * parties where goods will be collected. The same
    * collecting points may be included in different transport
    * routes, but in a different sequence.
    **/
   AEM("Transport route"),

   /**
    * Customer's unit inventory number
    * 
    * Number assigned by customer to a unique unit for
    * inventory purposes.
    **/
   AEN("Customer's unit inventory number"),

   /**
    * Product reservation number
    * 
    * Number assigned by seller to identify reservation of
    * specified products.
    **/
   AEO("Product reservation number"),

   /**
    * Project number
    * 
    * Reference number assigned to a project.
    **/
   AEP("Project number"),

   /**
    * Drawing list number
    * 
    * Reference number identifying a drawing list.
    **/
   AEQ("Drawing list number"),

   /**
    * Project specification number
    * 
    * Reference number identifying a project specification.
    **/
   AER("Project specification number"),

   /**
    * Primary reference
    * 
    * A number that identifies the primary reference.
    **/
   AES("Primary reference"),

   /**
    * Request for cancellation number
    * 
    * A number that identifies a request for cancellation.
    **/
   AET("Request for cancellation number"),

   /**
    * Supplier's control number
    * 
    * Reference to a file regarding a control of the supplier
    * carried out on departure of the goods.
    **/
   AEU("Supplier's control number"),

   /**
    * Shipping note number
    * 
    * [1123] Reference number assigned to a shipping note.
    **/
   AEV("Shipping note number"),

   /**
    * Empty container bill number
    * 
    * Reference number assigned to an empty container bill,
    * see: 1001 = 708.
    **/
   AEW("Empty container bill number"),

   /**
    * Non-negotiable maritime transport document number
    * 
    * Reference number assigned to a sea waybill, see: 1001 =
    * 712.
    **/
   AEX("Non-negotiable maritime transport document number"),

   /**
    * Substitute air waybill number
    * 
    * Reference number assigned to a substitute air waybill,
    * see: 1001 = 743.
    **/
   AEY("Substitute air waybill number"),

   /**
    * Despatch note (post parcels) number
    * 
    * (1128) Reference number assigned to a despatch note
    * (post parcels), see: 1001 = 750.
    **/
   AEZ("Despatch note (post parcels) number"),

   /**
    * Airlines flight identification number
    * 
    * (8028) Identification of a commercial flight by carrier
    * code and number as assigned by the airline (IATA).
    **/
   AF("Airlines flight identification number"),

   /**
    * Through bill of lading number
    * 
    * Reference number assigned to a through bill of lading,
    * see: 1001 = 761.
    **/
   AFA("Through bill of lading number"),

   /**
    * Cargo manifest number
    * 
    * [1037] Reference number assigned to a cargo manifest.
    **/
   AFB("Cargo manifest number"),

   /**
    * Bordereau number
    * 
    * Reference number assigned to a bordereau, see: 1001 =
    * 787.
    **/
   AFC("Bordereau number"),

   /**
    * Customs item number
    * 
    * Number (1496 in CST) assigned by the declarant to an
    * item.
    **/
   AFD("Customs item number"),

   /**
    * Export Control Commodity number (ECCN)
    * 
    * Reference number to relevant item within Commodity
    * Control List covering actual products change
    * functionality.
    **/
   AFE("Export Control Commodity number (ECCN)"),

   /**
    * Marking/label reference
    * 
    * Reference where marking/label information derives from.
    **/
   AFF("Marking/label reference"),

   /**
    * Tariff number
    * 
    * A number that identifies a tariff.
    **/
   AFG("Tariff number"),

   /**
    * Replenishment purchase order number
    * 
    * Purchase order number specified by the buyer for the
    * assignment to vendor's replenishment orders in a vendor
    * managed inventory program.
    **/
   AFH("Replenishment purchase order number"),

   /**
    * Immediate transportation no. for in bond movement
    * 
    * A number that identifies immediate transportation for in
    * bond movement.
    **/
   AFI("Immediate transportation no. for in bond movement"),

   /**
    * Transportation exportation no. for in bond movement
    * 
    * A number that identifies the transportation exportation
    * number for an in bond movement.
    **/
   AFJ("Transportation exportation no. for in bond movement"),

   /**
    * Immediate exportation no. for in bond movement
    * 
    * A number that identifies the immediate exportation
    * number for an in bond movement.
    **/
   AFK("Immediate exportation no. for in bond movement"),

   /**
    * Associated invoices
    * 
    * A number that identifies associated invoices.
    **/
   AFL("Associated invoices"),

   /**
    * Secondary Customs reference
    * 
    * A number that identifies the secondary customs
    * reference.
    **/
   AFM("Secondary Customs reference"),

   /**
    * Account party's reference
    * 
    * Reference of the account party.
    **/
   AFN("Account party's reference"),

   /**
    * Beneficiary's reference
    * 
    * Reference of the beneficiary.
    **/
   AFO("Beneficiary's reference"),

   /**
    * Second beneficiary's reference
    * 
    * Reference of the second beneficiary.
    **/
   AFP("Second beneficiary's reference"),

   /**
    * Applicant's bank reference
    * 
    * Reference number of the applicant's bank.
    **/
   AFQ("Applicant's bank reference"),

   /**
    * Issuing bank's reference
    * 
    * Reference number of the issuing bank.
    **/
   AFR("Issuing bank's reference"),

   /**
    * Beneficiary's bank reference
    * 
    * Reference number of the beneficiary's bank.
    **/
   AFS("Beneficiary's bank reference"),

   /**
    * Direct payment valuation number
    * 
    * Reference number assigned to a direct payment valuation.
    **/
   AFT("Direct payment valuation number"),

   /**
    * Direct payment valuation request number
    * 
    * Reference number assigned to a direct payment valuation
    * request.
    **/
   AFU("Direct payment valuation request number"),

   /**
    * Quantity valuation number
    * 
    * Reference number assigned to a quantity valuation.
    **/
   AFV("Quantity valuation number"),

   /**
    * Quantity valuation request number
    * 
    * Reference number assigned to a quantity valuation
    * request.
    **/
   AFW("Quantity valuation request number"),

   /**
    * Bill of quantities number
    * 
    * Reference number assigned to a bill of quantities.
    **/
   AFX("Bill of quantities number"),

   /**
    * Payment valuation number
    * 
    * Reference number assigned to a payment valuation.
    **/
   AFY("Payment valuation number"),

   /**
    * Situation number
    * 
    * Common reference number given to documents concerning a
    * determined period of works.
    **/
   AFZ("Situation number"),

   /**
    * Agreement to pay number
    * 
    * A number that identifies an agreement to pay.
    **/
   AGA("Agreement to pay number"),

   /**
    * Contract party reference number
    * 
    * Reference number assigned to a party for a particular
    * contract.
    **/
   AGB("Contract party reference number"),

   /**
    * Account party's bank reference
    * 
    * Reference number of the account party's bank.
    **/
   AGC("Account party's bank reference"),

   /**
    * Agent's bank reference
    * 
    * Reference number issued by the agent's bank.
    **/
   AGD("Agent's bank reference"),

   /**
    * Agent's reference
    * 
    * Reference number of the agent.
    **/
   AGE("Agent's reference"),

   /**
    * Applicant's reference
    * 
    * Reference number of the applicant.
    **/
   AGF("Applicant's reference"),

   /**
    * Dispute number
    * 
    * Reference number to a dispute notice.
    **/
   AGG("Dispute number"),

   /**
    * Credit rating agency's reference number
    * 
    * Reference number assigned by a credit rating agency to a
    * debtor.
    **/
   AGH("Credit rating agency's reference number"),

   /**
    * Request number
    * 
    * The reference number of a request.
    **/
   AGI("Request number"),

   /**
    * Single transaction sequence number
    * 
    * A number that identifies a single transaction sequence.
    **/
   AGJ("Single transaction sequence number"),

   /**
    * Application reference number
    * 
    * A number that identifies an application reference.
    **/
   AGK("Application reference number"),

   /**
    * Delivery verification certificate
    * 
    * Formal identification of delivery verification
    * certificate which is a formal document from Customs etc.
    * confirming that physical goods have been delivered. It
    * may be needed to support a tax reclaim based on an
    * invoice.
    **/
   AGL("Delivery verification certificate"),

   /**
    * Number of temporary importation document
    * 
    * Number assigned by customs to identify consignment in
    * transit.
    **/
   AGM("Number of temporary importation document"),

   /**
    * Reference number quoted on statement
    * 
    * Reference number quoted on the statement sent to the
    * beneficiary for information purposes.
    **/
   AGN("Reference number quoted on statement"),

   /**
    * Sender's reference to the original message
    * 
    * The reference provided by the sender of the original
    * message.
    **/
   AGO("Sender's reference to the original message"),

   /**
    * Company issued equipment ID
    * 
    * Owner/operator, non-government issued equipment
    * reference number.
    **/
   AGP("Company issued equipment ID"),

   /**
    * Domestic flight number
    * 
    * Airline flight number assigned to a flight originating
    * and terminating within the same country.
    **/
   AGQ("Domestic flight number"),

   /**
    * International flight number
    * 
    * Airline flight number assigned to a flight originating
    * and terminating across national borders.
    **/
   AGR("International flight number"),

   /**
    * Employer identification number of service bureau
    * 
    * Reference number assigned by a service/processing bureau
    * to an employer.
    **/
   AGS("Employer identification number of service bureau"),

   /**
    * Service group identification number
    * 
    * Identification used for a group of services.
    **/
   AGT("Service group identification number"),

   /**
    * Member number
    * 
    * Reference number assigned to a person as a member of a
    * group of persons or a service scheme.
    **/
   AGU("Member number"),

   /**
    * Previous member number
    * 
    * Reference number previously assigned to a member.
    **/
   AGV("Previous member number"),

   /**
    * Scheme/plan number
    * 
    * Reference number assigned to a service scheme or plan.
    **/
   AGW("Scheme/plan number"),

   /**
    * Previous scheme/plan number
    * 
    * Reference number previously assigned to a service scheme
    * or plan.
    **/
   AGX("Previous scheme/plan number"),

   /**
    * Receiving party's member identification
    * 
    * Identification used by the receiving party for a member
    * of a service scheme or group of persons.
    **/
   AGY("Receiving party's member identification"),

   /**
    * Payroll number
    * 
    * Reference number assigned to the payroll of an
    * organisation.
    **/
   AGZ("Payroll number"),

   /**
    * Packaging specification number
    * 
    * Reference number of documentation specifying the
    * technical detail of packaging requirements.
    **/
   AHA("Packaging specification number"),

   /**
    * Authority issued equipment identification
    * 
    * Identification issued by an authority, e.g. government,
    * airport authority.
    **/
   AHB("Authority issued equipment identification"),

   /**
    * Training flight number
    * 
    * Non-revenue producing airline flight for training
    * purposes.
    **/
   AHC("Training flight number"),

   /**
    * Fund code number
    * 
    * Reference number to identify appropriation and branch
    * chargeable for item.
    **/
   AHD("Fund code number"),

   /**
    * Signal code number
    * 
    * Reference number to identify a signal.
    **/
   AHE("Signal code number"),

   /**
    * Major force program number
    * 
    * Reference number according to Major Force Program (US).
    **/
   AHF("Major force program number"),

   /**
    * Nomination number
    * 
    * Reference number assigned by a shipper to a request/
    * commitment-to-ship on a pipeline system.
    **/
   AHG("Nomination number"),

   /**
    * Laboratory registration number
    * 
    * Reference number is the official registration number of
    * the laboratory.
    **/
   AHH("Laboratory registration number"),

   /**
    * Transport contract reference number
    * 
    * Reference number of a transport contract.
    **/
   AHI("Transport contract reference number"),

   /**
    * Payee's reference number
    * 
    * Reference number of the party to be paid.
    **/
   AHJ("Payee's reference number"),

   /**
    * Payer's reference number
    * 
    * Reference number of the party who pays.
    **/
   AHK("Payer's reference number"),

   /**
    * Creditor's reference number
    * 
    * Reference number of the party to whom a debt is owed.
    **/
   AHL("Creditor's reference number"),

   /**
    * Debtor's reference number
    * 
    * Reference number of the party who owes an amount of
    * money.
    **/
   AHM("Debtor's reference number"),

   /**
    * Joint venture reference number
    * 
    * Reference number assigned to a joint venture agreement.
    **/
   AHN("Joint venture reference number"),

   /**
    * Chamber of Commerce registration number
    * 
    * The registration number by which a company/organization
    * is known to the Chamber of Commerce.
    **/
   AHO("Chamber of Commerce registration number"),

   /**
    * Tax registration number
    * 
    * The registration number by which a company/organization
    * is identified with the tax administration.
    **/
   AHP("Tax registration number"),

   /**
    * Wool identification number
    * 
    * Shipping Identification Mark (SIM) allocated to a wool
    * consignment by a shipping company.
    **/
   AHQ("Wool identification number"),

   /**
    * Wool tax reference number
    * 
    * Reference or indication of the payment of wool tax.
    **/
   AHR("Wool tax reference number"),

   /**
    * Meat processing establishment registration number
    * 
    * Registration number allocated to a registered meat
    * packing establishment by the local quarantine and
    * inspection authority.
    **/
   AHS("Meat processing establishment registration number"),

   /**
    * Quarantine/treatment status reference number
    * 
    * Coded quarantine/treatment status of a container and its
    * cargo and packing materials, generated by a shipping
    * company based upon declarations presented by a shipper.
    **/
   AHT("Quarantine/treatment status reference number"),

   /**
    * Request for quote number
    * 
    * Reference number assigned by the requestor to a request
    * for quote.
    **/
   AHU("Request for quote number"),

   /**
    * Manual processing authority number
    * 
    * Number allocated to allow the manual processing of an
    * entity.
    **/
   AHV("Manual processing authority number"),

   /**
    * Rate note number
    * 
    * Reference assigned to a specific rate.
    **/
   AHX("Rate note number"),

   /**
    * Freight Forwarder number
    * 
    * An identification code of a Freight Forwarder.
    **/
   AHY("Freight Forwarder number"),

   /**
    * Customs release code
    * 
    * A code associated to a requirement that must be
    * presented to gain the release of goods by Customs.
    **/
   AHZ("Customs release code"),

   /**
    * Compliance code number
    * 
    * Number assigned to indicate regulatory compliance.
    **/
   AIA("Compliance code number"),

   /**
    * Department of transportation bond number
    * 
    * Number of a bond assigned by the department of
    * transportation.
    **/
   AIB("Department of transportation bond number"),

   /**
    * Export establishment number
    * 
    * Number to identify export establishment.
    **/
   AIC("Export establishment number"),

   /**
    * Certificate of conformity
    * 
    * Certificate certifying the conformity to predefined
    * definitions.
    **/
   AID("Certificate of conformity"),

   /**
    * Ministerial certificate of homologation
    * 
    * Certificate of approval for components which are subject
    * to legal restrictions and must be approved by the
    * government.
    **/
   AIE("Ministerial certificate of homologation"),

   /**
    * Previous delivery instruction number
    * 
    * The identification of a previous delivery instruction.
    **/
   AIF("Previous delivery instruction number"),

   /**
    * Passport number
    * 
    * Number assigned to a passport.
    **/
   AIG("Passport number"),

   /**
    * Common transaction reference number
    * 
    * Reference number applicable to different underlying
    * individual transactions.
    **/
   AIH("Common transaction reference number"),

   /**
    * Bank's common transaction reference number
    * 
    * Bank's reference number allocated by the bank to
    * different underlying individual transactions.
    **/
   AII("Bank's common transaction reference number"),

   /**
    * Customer's individual transaction reference number
    * 
    * Customer's reference number allocated by the customer to
    * one specific transaction.
    **/
   AIJ("Customer's individual transaction reference number"),

   /**
    * Bank's individual transaction reference number
    * 
    * Bank's reference number allocated by the bank to one
    * specific transaction.
    **/
   AIK("Bank's individual transaction reference number"),

   /**
    * Customer's common transaction reference number
    * 
    * Customer's reference number allocated by the customer to
    * different underlying individual transactions.
    **/
   AIL("Customer's common transaction reference number"),

   /**
    * Individual transaction reference number
    * 
    * Reference number applying to one specific transaction.
    **/
   AIM("Individual transaction reference number"),

   /**
    * Product sourcing agreement number
    * 
    * Reference number assigned to a product sourcing
    * agreement.
    **/
   AIN("Product sourcing agreement number"),

   /**
    * Customs transhipment number
    * 
    * Approval number issued by Customs for cargo to be
    * transhipped under Customs control.
    **/
   AIO("Customs transhipment number"),

   /**
    * Customs preference inquiry number
    * 
    * The number assigned by Customs to a preference inquiry.
    **/
   AIP("Customs preference inquiry number"),

   /**
    * Packing plant number
    * 
    * Number to identify packing establishment.
    **/
   AIQ("Packing plant number"),

   /**
    * Original certificate number
    * 
    * Number giving reference to an original certificate
    * number.
    **/
   AIR("Original certificate number"),

   /**
    * Processing plant number
    * 
    * Number to identify processing plant.
    **/
   AIS("Processing plant number"),

   /**
    * Slaughter plant number
    * 
    * Number to identify slaughter plant.
    **/
   AIT("Slaughter plant number"),

   /**
    * Charge card account number
    * 
    * Number to identify charge card account.
    **/
   AIU("Charge card account number"),

   /**
    * Event reference number
    * 
    * [1007] Reference number identifying an event.
    **/
   AIV("Event reference number"),

   /**
    * Transport section reference number
    * 
    * A number identifying a transport section.
    **/
   AIW("Transport section reference number"),

   /**
    * Referred product for mechanical analysis
    * 
    * A product number identifying the product which is used
    * for mechanical analysis considered valid for a group of
    * products.
    **/
   AIX("Referred product for mechanical analysis"),

   /**
    * Referred product for chemical analysis
    * 
    * A product number identifying the product which is used
    * for chemical analysis considered valid for a group of
    * products.
    **/
   AIY("Referred product for chemical analysis"),

   /**
    * Consolidated invoice number
    * 
    * Invoice number into which other invoices are
    * consolidated.
    **/
   AIZ("Consolidated invoice number"),

   /**
    * Part reference indicator in a drawing
    * 
    * To designate the number which provides a cross reference
    * between parts contained in a drawing and a parts
    * catalogue.
    **/
   AJA("Part reference indicator in a drawing"),

   /**
    * U.S. Code of Federal Regulations (CFR)
    * 
    * A reference indicating a citation from the U.S. Code of
    * Federal Regulations (CFR).
    **/
   AJB("U.S. Code of Federal Regulations (CFR)"),

   /**
    * Purchasing activity clause number
    * 
    * A number indicating a clause applicable to a purchasing
    * activity.
    **/
   AJC("Purchasing activity clause number"),

   /**
    * U.S. Defense Federal Acquisition Regulation Supplement
    * 
    * A reference indicating a citation from the U.S. Defense
    * Federal Acquisition Regulation Supplement.
    **/
   AJD("U.S. Defense Federal Acquisition Regulation Supplement"),

   /**
    * Agency clause number
    * 
    * A number indicating a clause applicable to a particular
    * agency.
    **/
   AJE("Agency clause number"),

   /**
    * Circular publication number
    * 
    * A number specifying a circular publication.
    **/
   AJF("Circular publication number"),

   /**
    * U.S. Federal Acquisition Regulation
    * 
    * A reference indicating a citation from the U.S. Federal
    * Acquisition Regulation.
    **/
   AJG("U.S. Federal Acquisition Regulation"),

   /**
    * U.S. General Services Administration Regulation
    * 
    * A reference indicating a citation from U.S. General
    * Services Administration Regulation.
    **/
   AJH("U.S. General Services Administration Regulation"),

   /**
    * U.S. Federal Information Resources Management Regulation
    * 
    * A reference indicating a citation from U.S. Federal
    * Information Resources Management Regulation.
    **/
   AJI("U.S. Federal Information Resources Management Regulation"),

   /**
    * Paragraph
    * 
    * A reference indicating a paragraph cited as the source
    * of information.
    **/
   AJJ("Paragraph"),

   /**
    * Special instructions number
    * 
    * A number indicating a citation used for special
    * instructions.
    **/
   AJK("Special instructions number"),

   /**
    * Site specific procedures, terms, and conditions number
    * 
    * A number indicating a set of site specific procedures,
    * terms and conditions.
    **/
   AJL("Site specific procedures, terms, and conditions number"),

   /**
    * Master solicitation procedures, terms, and conditions
    * 
    * number
    * A number indicating a master solicitation containing
    * procedures, terms and conditions.
    **/
   AJM("Master solicitation procedures, terms, and conditions"),

   /**
    * U.S. Department of Veterans Affairs Acquisition Regulation
    * 
    * A reference indicating a citation from the U.S.
    * Department of Veterans Affairs Acquisition Regulation.
    **/
   AJN("U.S. Department of Veterans Affairs Acquisition Regulation"),

   /**
    * Military Interdepartmental Purchase Request (MIPR) number
    * 
    * A number indicating an interdepartmental purchase
    * request used by the military.
    **/
   AJO("Military Interdepartmental Purchase Request (MIPR) number"),

   /**
    * Foreign military sales number
    * 
    * A number specifying a sale to a foreign military.
    **/
   AJP("Foreign military sales number"),

   /**
    * Defense priorities allocation system priority rating
    * 
    * A reference indicating a priority rating assigned to
    * allocate resources for defense purchases.
    **/
   AJQ("Defense priorities allocation system priority rating"),

   /**
    * Wage determination number
    * 
    * A number specifying a wage determination.
    **/
   AJR("Wage determination number"),

   /**
    * Agreement number
    * 
    * A number specifying an agreement between parties.
    **/
   AJS("Agreement number"),

   /**
    * Standard Industry Classification (SIC) number
    * 
    * A number specifying a standard industry classification.
    **/
   AJT("Standard Industry Classification (SIC) number"),

   /**
    * End item number
    * 
    * A number specifying the end item applicable to a
    * subordinate item.
    **/
   AJU("End item number"),

   /**
    * Federal supply schedule item number
    * 
    * A number specifying an item listed in a federal supply
    * schedule.
    **/
   AJV("Federal supply schedule item number"),

   /**
    * Technical document number
    * 
    * A number specifying a technical document.
    **/
   AJW("Technical document number"),

   /**
    * Technical order number
    * 
    * A reference to an order that specifies a technical
    * change.
    **/
   AJX("Technical order number"),

   /**
    * Suffix
    * 
    * A reference to specify a suffix added to the end of a
    * basic identifier.
    **/
   AJY("Suffix"),

   /**
    * Transportation account number
    * 
    * An account number to be charged or credited for
    * transportation.
    **/
   AJZ("Transportation account number"),

   /**
    * Container disposition order reference number
    * 
    * Reference assigned to the empty container disposition
    * order.
    **/
   AKA("Container disposition order reference number"),

   /**
    * Container prefix
    * 
    * The first part of the unique identification of a
    * container formed by an alpha code identifying the owner
    * of the container.
    **/
   AKB("Container prefix"),

   /**
    * Transport equipment return reference
    * 
    * Reference known at the address to return equipment to.
    **/
   AKC("Transport equipment return reference"),

   /**
    * Transport equipment survey reference
    * 
    * Reference number assigned by the ordering party to the
    * transport equipment survey order.
    **/
   AKD("Transport equipment survey reference"),

   /**
    * Transport equipment survey report number
    * 
    * Reference number used by a party to identify its
    * transport equipment survey report.
    **/
   AKE("Transport equipment survey report number"),

   /**
    * Transport equipment stuffing order
    * 
    * Reference number assigned to the order to stuff goods in
    * transport equipment.
    **/
   AKF("Transport equipment stuffing order"),

   /**
    * Vehicle Identification Number (VIN)
    * 
    * The identification number which uniquely distinguishes
    * one vehicle from another through the lifespan of the
    * vehicle.
    **/
   AKG("Vehicle Identification Number (VIN)"),

   /**
    * Government bill of lading
    * 
    * Bill of lading as defined by the government.
    **/
   AKH("Government bill of lading"),

   /**
    * Ordering customer's second reference number
    * 
    * Ordering customer's second reference number.
    **/
   AKI("Ordering customer's second reference number"),

   /**
    * Direct debit reference
    * 
    * Reference number assigned to the direct debit operation.
    **/
   AKJ("Direct debit reference"),

   /**
    * Meter reading at the beginning of the delivery
    * 
    * Meter reading at the beginning of the delivery.
    **/
   AKK("Meter reading at the beginning of the delivery"),

   /**
    * Meter reading at the end of delivery
    * 
    * Meter reading at the end of the delivery.
    **/
   AKL("Meter reading at the end of delivery"),

   /**
    * Replenishment purchase order range start number
    * 
    * Starting number of a range of purchase order numbers
    * assigned by the buyer to vendor's replenishment orders.
    **/
   AKM("Replenishment purchase order range start number"),

   /**
    * Third bank's reference
    * 
    * Reference number of the third bank.
    **/
   AKN("Third bank's reference"),

   /**
    * Action authorization number
    * 
    * A reference number authorizing an action.
    **/
   AKO("Action authorization number"),

   /**
    * Appropriation number
    * 
    * The number identifying a type of funding for a specific
    * purpose (appropriation).
    **/
   AKP("Appropriation number"),

   /**
    * Product change authority number
    * 
    * Number which authorises a change in form, fit or
    * function of a product.
    **/
   AKQ("Product change authority number"),

   /**
    * General cargo consignment reference number
    * 
    * Reference number identifying a particular general cargo
    * (non-containerised or break bulk) consignment.
    **/
   AKR("General cargo consignment reference number"),

   /**
    * Catalogue sequence number
    * 
    * A number which uniquely identifies an item within a
    * catalogue according to a standard numbering system.
    **/
   AKS("Catalogue sequence number"),

   /**
    * Forwarding order number
    * 
    * Reference number assigned to the forwarding order by the
    * ordering customer.
    **/
   AKT("Forwarding order number"),

   /**
    * Transport equipment survey reference number
    * 
    * Reference number known at the address where the
    * transport equipment will be or has been surveyed.
    **/
   AKU("Transport equipment survey reference number"),

   /**
    * Lease contract reference
    * 
    * Reference number of the lease contract.
    **/
   AKV("Lease contract reference"),

   /**
    * Transport costs reference number
    * 
    * Reference number of the transport costs.
    **/
   AKW("Transport costs reference number"),

   /**
    * Transport equipment stripping order
    * 
    * Reference number assigned to the order to strip goods
    * from transport equipment.
    **/
   AKX("Transport equipment stripping order"),

   /**
    * Prior policy number
    * 
    * The number of the prior policy.
    **/
   AKY("Prior policy number"),

   /**
    * Policy number
    * 
    * Number assigned to a policy.
    **/
   AKZ("Policy number"),

   /**
    * Procurement budget number
    * 
    * A number which uniquely identifies a procurement budget
    * against which commitments or invoices can be allocated.
    **/
   ALA("Procurement budget number"),

   /**
    * Domestic inventory management code
    * 
    * Code to identify the management of domestic inventory.
    **/
   ALB("Domestic inventory management code"),

   /**
    * Customer reference number assigned to previous balance of
    * 
    * payment information
    * Identification number of the previous balance of
    * payments information from customer message.
    **/
   ALC("Customer reference number assigned to previous balance of"),

   /**
    * Previous credit advice reference number
    * 
    * Reference number of the previous "Credit advice"
    * message.
    **/
   ALD("Previous credit advice reference number"),

   /**
    * Reporting form number
    * 
    * Reference number assigned to the reporting form.
    **/
   ALE("Reporting form number"),

   /**
    * Authorization number for exception to dangerous goods
    * 
    * regulations
    * Reference number allocated by an authority. This number
    * contains an approval concerning exceptions on the
    * existing dangerous goods regulations.
    **/
   ALF("Authorization number for exception to dangerous goods"),

   /**
    * Dangerous goods security number
    * 
    * Reference number allocated by an authority in order to
    * control the dangerous goods on board of a specific means
    * of transport for dangerous goods security purposes.
    **/
   ALG("Dangerous goods security number"),

   /**
    * Dangerous goods transport licence number
    * 
    * Licence number allocated by an authority as to the
    * permission of carrying dangerous goods by a specific
    * means of transport.
    **/
   ALH("Dangerous goods transport licence number"),

   /**
    * Previous rental agreement number
    * 
    * Number to identify the previous rental agreement number.
    **/
   ALI("Previous rental agreement number"),

   /**
    * Next rental agreement reason number
    * 
    * Number to identify the reason for the next rental
    * agreement.
    **/
   ALJ("Next rental agreement reason number"),

   /**
    * Consignee's invoice number
    * 
    * The invoice number assigned by a consignee.
    **/
   ALK("Consignee's invoice number"),

   /**
    * Message batch number
    * 
    * A number identifying a batch of messages.
    **/
   ALL("Message batch number"),

   /**
    * Previous delivery schedule number
    * 
    * A reference number identifying a previous delivery
    * schedule.
    **/
   ALM("Previous delivery schedule number"),

   /**
    * Physical inventory recount reference number
    * 
    * A reference to a re-count of physically held inventory.
    **/
   ALN("Physical inventory recount reference number"),

   /**
    * Receiving advice number
    * 
    * A reference number to a receiving advice.
    **/
   ALO("Receiving advice number"),

   /**
    * Returnable container reference number
    * 
    * A reference number identifying a returnable container.
    **/
   ALP("Returnable container reference number"),

   /**
    * Returns notice number
    * 
    * A reference number to a returns notice.
    **/
   ALQ("Returns notice number"),

   /**
    * Sales forecast number
    * 
    * A reference number identifying a sales forecast.
    **/
   ALR("Sales forecast number"),

   /**
    * Sales report number
    * 
    * A reference number identifying a sales report.
    **/
   ALS("Sales report number"),

   /**
    * Previous tax control number
    * 
    * A reference number identifying a previous tax control
    * number.
    **/
   ALT("Previous tax control number"),

   /**
    * AGERD (Aerospace Ground Equipment Requirement Data) number
    * 
    * Identifies the equipment required to conduct
    * maintenance.
    **/
   ALU("AGERD (Aerospace Ground Equipment Requirement Data) number"),

   /**
    * Registered capital reference
    * 
    * Registered capital reference of a company.
    **/
   ALV("Registered capital reference"),

   /**
    * Standard number of inspection document
    * 
    * Code identifying the standard number of the inspection
    * document supplied.
    **/
   ALW("Standard number of inspection document"),

   /**
    * Model
    * 
    * (7242) A reference used to identify a model.
    **/
   ALX("Model"),

   /**
    * Financial management reference
    * 
    * A financial management reference.
    **/
   ALY("Financial management reference"),

   /**
    * NOTIfication for COLlection number (NOTICOL)
    * 
    * A reference assigned by a consignor to a notification
    * document which indicates the availability of goods for
    * collection.
    **/
   ALZ("NOTIfication for COLlection number (NOTICOL)"),

   /**
    * Previous request for metered reading reference number
    * 
    * Number to identify a previous request for a recording or
    * reading of a measuring device.
    **/
   AMA("Previous request for metered reading reference number"),

   /**
    * Next rental agreement number
    * 
    * Number to identify the next rental agreement.
    **/
   AMB("Next rental agreement number"),

   /**
    * Reference number of a request for metered reading
    * 
    * Number to identify a request for a recording or reading
    * of a measuring device to be taken.
    **/
   AMC("Reference number of a request for metered reading"),

   /**
    * Hastening number
    * 
    * A number which uniquely identifies a request to hasten
    * an action.
    **/
   AMD("Hastening number"),

   /**
    * Repair data request number
    * 
    * A number which uniquely identifies a request for data
    * about repairs.
    **/
   AME("Repair data request number"),

   /**
    * Consumption data request number
    * 
    * A number which identifies a request for consumption
    * data.
    **/
   AMF("Consumption data request number"),

   /**
    * Profile number
    * 
    * Reference number allocated to a discrete set of
    * criteria.
    **/
   AMG("Profile number"),

   /**
    * Case number
    * 
    * Number assigned to a case.
    **/
   AMH("Case number"),

   /**
    * Government quality assurance and control level Number
    * 
    * A number which identifies the level of quality assurance
    * and control required by the government for an article.
    **/
   AMI("Government quality assurance and control level Number"),

   /**
    * Payment plan reference
    * 
    * A number which uniquely identifies a payment plan.
    **/
   AMJ("Payment plan reference"),

   /**
    * Replaced meter unit number
    * 
    * Number identifying the replaced meter unit.
    **/
   AMK("Replaced meter unit number"),

   /**
    * Replenishment purchase order range end number
    * 
    * Ending number of a range of purchase order numbers
    * assigned by the buyer to vendor's replenishment orders.
    **/
   AML("Replenishment purchase order range end number"),

   /**
    * Insurer assigned reference number
    * 
    * A unique reference number assigned by the insurer.
    **/
   AMM("Insurer assigned reference number"),

   /**
    * Canadian excise entry number
    * 
    * An excise entry number assigned by the Canadian Customs.
    **/
   AMN("Canadian excise entry number"),

   /**
    * Premium rate table
    * 
    * Identifies the premium rate table.
    **/
   AMO("Premium rate table"),

   /**
    * Advise through bank's reference
    * 
    * Financial institution through which the advising bank is
    * to advise the documentary credit.
    **/
   AMP("Advise through bank's reference"),

   /**
    * US, Department of Transportation bond surety code
    * 
    * A bond surety code assigned by the United States
    * Department of Transportation (DOT).
    **/
   AMQ("US, Department of Transportation bond surety code"),

   /**
    * US, Food and Drug Administration establishment indicator
    * 
    * An establishment indicator assigned by the United States
    * Food and Drug Administration.
    **/
   AMR("US, Food and Drug Administration establishment indicator"),

   /**
    * US, Federal Communications Commission (FCC) import
    * 
    * condition number
    * A number known as the United States Federal
    * Communications Commission (FCC) import condition number
    * applying to certain types of regulated communications
    * equipment.
    **/
   AMS("US, Federal Communications Commission (FCC) import"),

   /**
    * Goods and Services Tax identification number
    * 
    * Identifier assigned to an entity by a tax authority for
    * Goods and Services Tax (GST) related purposes.
    **/
   AMT("Goods and Services Tax identification number"),

   /**
    * Integrated logistic support cross reference number
    * 
    * Provides the identification of the reference which
    * allows cross referencing of items between different
    * areas of integrated logistics support.
    **/
   AMU("Integrated logistic support cross reference number"),

   /**
    * Department number
    * 
    * Number assigned to a department within an organization.
    **/
   AMV("Department number"),

   /**
    * Buyer's catalogue number
    * 
    * Identification of a catalogue maintained by a buyer.
    **/
   AMW("Buyer's catalogue number"),

   /**
    * Financial settlement party's reference number
    * 
    * Reference number of the party who is responsible for the
    * financial settlement.
    **/
   AMX("Financial settlement party's reference number"),

   /**
    * Standard's version number
    * 
    * The version number assigned to a standard.
    **/
   AMY("Standard's version number"),

   /**
    * Pipeline number
    * 
    * Number to identify a pipeline.
    **/
   AMZ("Pipeline number"),

   /**
    * Account servicing bank's reference number
    * 
    * Reference number of the account servicing bank.
    **/
   ANA("Account servicing bank's reference number"),

   /**
    * Completed units payment request reference
    * 
    * A reference to a payment request for completed units.
    **/
   ANB("Completed units payment request reference"),

   /**
    * Payment in advance request reference
    * 
    * A reference to a request for payment in advance.
    **/
   ANC("Payment in advance request reference"),

   /**
    * Parent file
    * 
    * Identifies the parent file in a structure of related
    * files.
    **/
   AND("Parent file"),

   /**
    * Sub file
    * 
    * Identifies the sub file in a structure of related files.
    **/
   ANE("Sub file"),

   /**
    * CAD file layer convention
    * 
    * Reference number identifying a layer convention for a
    * file in a Computer Aided Design (CAD) environment.
    **/
   ANF("CAD file layer convention"),

   /**
    * Technical regulation
    * 
    * Reference number identifying a technical regulation.
    **/
   ANG("Technical regulation"),

   /**
    * Plot file
    * 
    * Reference number indicating that the file is a plot
    * file.
    **/
   ANH("Plot file"),

   /**
    * File conversion journal
    * 
    * Reference number identifying a journal recording details
    * about conversion operations between file formats.
    **/
   ANI("File conversion journal"),

   /**
    * Authorization number
    * 
    * A number which uniquely identifies an authorization.
    **/
   ANJ("Authorization number"),

   /**
    * Reference number assigned by third party
    * 
    * Reference number assigned by a third party.
    **/
   ANK("Reference number assigned by third party"),

   /**
    * Deposit reference number
    * 
    * A reference number identifying a deposit.
    **/
   ANL("Deposit reference number"),

   /**
    * Named bank's reference
    * 
    * Reference number of the named bank.
    **/
   ANM("Named bank's reference"),

   /**
    * Drawee's reference
    * 
    * Reference number of the drawee.
    **/
   ANN("Drawee's reference"),

   /**
    * Case of need party's reference
    * 
    * Reference number of the case of need party.
    **/
   ANO("Case of need party's reference"),

   /**
    * Collecting bank's reference
    * 
    * Reference number of the collecting bank.
    **/
   ANP("Collecting bank's reference"),

   /**
    * Remitting bank's reference
    * 
    * Reference number of the remitting bank.
    **/
   ANQ("Remitting bank's reference"),

   /**
    * Principal's bank reference
    * 
    * Reference number of the principal's bank.
    **/
   ANR("Principal's bank reference"),

   /**
    * Presenting bank's reference
    * 
    * Reference number of the presenting bank.
    **/
   ANS("Presenting bank's reference"),

   /**
    * Consignee's reference
    * 
    * Reference number of the consignee.
    **/
   ANT("Consignee's reference"),

   /**
    * Financial transaction reference number
    * 
    * Reference number of the financial transaction.
    **/
   ANU("Financial transaction reference number"),

   /**
    * Credit reference number
    * 
    * The reference number of a credit instruction.
    **/
   ANV("Credit reference number"),

   /**
    * Receiving bank's authorization number
    * 
    * Authorization number of the receiving bank.
    **/
   ANW("Receiving bank's authorization number"),

   /**
    * Clearing reference
    * 
    * Reference allocated by a clearing procedure.
    **/
   ANX("Clearing reference"),

   /**
    * Sending bank's reference number
    * 
    * Reference number of the sending bank.
    **/
   ANY("Sending bank's reference number"),

   /**
    * Documentary payment reference
    * 
    * Reference of the documentary payment.
    **/
   AOA("Documentary payment reference"),

   /**
    * Accounting file reference
    * 
    * Reference of an accounting file.
    **/
   AOD("Accounting file reference"),

   /**
    * Sender's file reference number
    * 
    * File reference number assigned by the sender.
    **/
   AOE("Sender's file reference number"),

   /**
    * Receiver's file reference number
    * 
    * File reference number assigned by the receiver.
    **/
   AOF("Receiver's file reference number"),

   /**
    * Source document internal reference
    * 
    * Reference number assigned to a source document for
    * internal usage.
    **/
   AOG("Source document internal reference"),

   /**
    * Principal's reference
    * 
    * Reference number of the principal.
    **/
   AOH("Principal's reference"),

   /**
    * Debit reference number
    * 
    * The reference number of a debit instruction.
    **/
   AOI("Debit reference number"),

   /**
    * Calendar
    * 
    * A calendar reference number.
    **/
   AOJ("Calendar"),

   /**
    * Work shift
    * 
    * A work shift reference number.
    **/
   AOK("Work shift"),

   /**
    * Work breakdown structure
    * 
    * A structure reference that identifies the breakdown of
    * work for a project.
    **/
   AOL("Work breakdown structure"),

   /**
    * Organisation breakdown structure
    * 
    * A structure reference that identifies the breakdown of
    * an organisation.
    **/
   AOM("Organisation breakdown structure"),

   /**
    * Work task charge number
    * 
    * A reference assigned to a specific work task charge.
    **/
   AON("Work task charge number"),

   /**
    * Functional work group
    * 
    * A reference to identify a functional group performing
    * work.
    **/
   AOO("Functional work group"),

   /**
    * Work team
    * 
    * A reference to identify a team performing work.
    **/
   AOP("Work team"),

   /**
    * Department
    * 
    * Section of an organisation.
    **/
   AOQ("Department"),

   /**
    * Statement of work
    * 
    * A reference number for a statement of work.
    **/
   AOR("Statement of work"),

   /**
    * Work package
    * 
    * A reference for a detailed package of work.
    **/
   AOS("Work package"),

   /**
    * Planning package
    * 
    * A reference for a planning package of work.
    **/
   AOT("Planning package"),

   /**
    * Cost account
    * 
    * A cost control account reference.
    **/
   AOU("Cost account"),

   /**
    * Work order
    * 
    * Reference number for an order to do work.
    **/
   AOV("Work order"),

   /**
    * Transportation Control Number (TCN)
    * 
    * A number assigned for transportation purposes.
    **/
   AOW("Transportation Control Number (TCN)"),

   /**
    * Constraint notation
    * 
    * Identifies a reference to a constraint notation.
    **/
   AOX("Constraint notation"),

   /**
    * ETERMS reference
    * 
    * Identifies a reference to the ICC (International Chamber
    * of Commerce) ETERMS(tm) repository of electronic
    * commerce trading terms and conditions.
    **/
   AOY("ETERMS reference"),

   /**
    * Implementation version number
    * 
    * Identifies a version number of an implementation.
    **/
   AOZ("Implementation version number"),

   /**
    * Accounts receivable number
    * 
    * Reference number assigned by accounts receivable
    * department to the account of a specific debtor.
    **/
   AP("Accounts receivable number"),

   /**
    * Incorporated legal reference
    * 
    * Identifies a legal reference which is deemed
    * incorporated by reference.
    **/
   APA("Incorporated legal reference"),

   /**
    * Payment instalment reference number
    * 
    * A reference number given to a payment instalment to
    * identify a specific instance of payment of a debt which
    * can be paid at specified intervals.
    **/
   APB("Payment instalment reference number"),

   /**
    * Equipment owner reference number
    * 
    * Reference number issued by the owner of the equipment.
    **/
   APC("Equipment owner reference number"),

   /**
    * Cedent's claim number
    * 
    * To identify the number assigned to the claim by the
    * ceding company.
    **/
   APD("Cedent's claim number"),

   /**
    * Reinsurer's claim number
    * 
    * To identify the number assigned to the claim by the
    * reinsurer.
    **/
   APE("Reinsurer's claim number"),

   /**
    * Price/sales catalogue response reference number
    * 
    * A reference number identifying a response to a
    * price/sales catalogue.
    **/
   APF("Price/sales catalogue response reference number"),

   /**
    * General purpose message reference number
    * 
    * A reference number identifying a general purpose
    * message.
    **/
   APG("General purpose message reference number"),

   /**
    * Invoicing data sheet reference number
    * 
    * A reference number identifying an invoicing data sheet.
    **/
   APH("Invoicing data sheet reference number"),

   /**
    * Inventory report reference number
    * 
    * A reference number identifying an inventory report.
    **/
   API("Inventory report reference number"),

   /**
    * Ceiling formula reference number
    * 
    * The reference number which identifies a formula for
    * determining a ceiling.
    **/
   APJ("Ceiling formula reference number"),

   /**
    * Price variation formula reference number
    * 
    * The reference number which identifies a price variation
    * formula.
    **/
   APK("Price variation formula reference number"),

   /**
    * Reference to account servicing bank's message
    * 
    * Reference to the account servicing bank's message.
    **/
   APL("Reference to account servicing bank's message"),

   /**
    * Party sequence number
    * 
    * Reference identifying a party sequence number.
    **/
   APM("Party sequence number"),

   /**
    * Purchaser's request reference
    * 
    * Reference identifying a request made by the purchaser.
    **/
   APN("Purchaser's request reference"),

   /**
    * Contractor request reference
    * 
    * Reference identifying a request made by a contractor.
    **/
   APO("Contractor request reference"),

   /**
    * Accident reference number
    * 
    * Reference number assigned to an accident.
    **/
   APP("Accident reference number"),

   /**
    * Commercial account summary reference number
    * 
    * A reference number identifying a commercial account
    * summary.
    **/
   APQ("Commercial account summary reference number"),

   /**
    * Contract breakdown reference
    * 
    * A reference which identifies a specific breakdown of a
    * contract.
    **/
   APR("Contract breakdown reference"),

   /**
    * Contractor registration number
    * 
    * A reference number used to identify a contractor.
    **/
   APS("Contractor registration number"),

   /**
    * Applicable coefficient identification number
    * 
    * The identification number of the coefficient which is
    * applicable.
    **/
   APT("Applicable coefficient identification number"),

   /**
    * Special budget account number
    * 
    * The number of a special budget account.
    **/
   APU("Special budget account number"),

   /**
    * Authorisation for repair reference
    * 
    * Reference of the authorisation for repair.
    **/
   APV("Authorisation for repair reference"),

   /**
    * Manufacturer defined repair rates reference
    * 
    * Reference assigned by a manufacturer to their repair
    * rates.
    **/
   APW("Manufacturer defined repair rates reference"),

   /**
    * Original submitter log number
    * 
    * A control number assigned by the original submitter.
    **/
   APX("Original submitter log number"),

   /**
    * Original submitter, parent Data Maintenance Request (DMR)
    * 
    * log number
    * A Data Maintenance Request (DMR) original submitter's
    * reference log number for the parent DMR.
    **/
   APY("Original submitter, parent Data Maintenance Request (DMR)"),

   /**
    * Original submitter, child Data Maintenance Request (DMR)
    * 
    * log number
    * A Data Maintenance Request (DMR) original submitter's
    * reference log number for a child DMR.
    **/
   APZ("Original submitter, child Data Maintenance Request (DMR)"),

   /**
    * Entry point assessment log number
    * 
    * The reference log number assigned by an entry point
    * assessment group for the DMR.
    **/
   AQA("Entry point assessment log number"),

   /**
    * Entry point assessment log number, parent DMR
    * 
    * The reference log number assigned by an entry point
    * assessment group for the parent Data Maintenance Request
    * (DMR).
    **/
   AQB("Entry point assessment log number, parent DMR"),

   /**
    * Entry point assessment log number, child DMR
    * 
    * The reference log number assigned by an entry point
    * assessment group for a child Data Maintenance Request
    * (DMR).
    **/
   AQC("Entry point assessment log number, child DMR"),

   /**
    * Data structure tag
    * 
    * The tag assigned to a data structure.
    **/
   AQD("Data structure tag"),

   /**
    * Central secretariat log number
    * 
    * The reference log number assigned by the central
    * secretariat for the Data Maintenance Request (DMR).
    **/
   AQE("Central secretariat log number"),

   /**
    * Central secretariat log number, parent Data Maintenance
    * 
    * Request (DMR)
    * The reference log number assigned by the central
    * secretariat for the parent Data Maintenance Request
    * (DMR).
    **/
   AQF("Central secretariat log number, parent Data Maintenance"),

   /**
    * Central secretariat log number, child Data Maintenance
    * 
    * Request (DMR)
    * The reference log number assigned by the central
    * secretariat for the child Data Maintenance Request
    * (DMR).
    **/
   AQG("Central secretariat log number, child Data Maintenance"),

   /**
    * International assessment log number
    * 
    * The reference log number assigned to a Data Maintenance
    * Request (DMR) changed in international assessment.
    **/
   AQH("International assessment log number"),

   /**
    * International assessment log number, parent Data
    * 
    * Maintenance Request (DMR)
    * The reference log number assigned to a Data Maintenance
    * Request (DMR) changed in international assessment that
    * is a parent to the current DMR.
    **/
   AQI("International assessment log number, parent Data"),

   /**
    * International assessment log number, child Data Maintenance
    * 
    * Request (DMR)
    * The reference log number assigned to a Data Maintenance
    * Request (DMR) changed in international assessment that
    * is a child to the current DMR.
    **/
   AQJ("International assessment log number, child Data Maintenance"),

   /**
    * Status report number
    * 
    * (1125) The reference number for a status report.
    **/
   AQK("Status report number"),

   /**
    * Message design group number
    * 
    * Reference number for a message design group.
    **/
   AQL("Message design group number"),

   /**
    * US Customs Service (USCS) entry code
    * 
    * An entry number assigned by the United States (US)
    * customs service.
    **/
   AQM("US Customs Service (USCS) entry code"),

   /**
    * Beginning job sequence number
    * 
    * The number designating the beginning of the job
    * sequence.
    **/
   AQN("Beginning job sequence number"),

   /**
    * Sender's clause number
    * 
    * The number that identifies the sender's clause.
    **/
   AQO("Sender's clause number"),

   /**
    * Dun and Bradstreet Canada's 8 digit Standard Industrial
    * 
    * Classification (SIC) code
    * Dun and Bradstreet Canada's 8 digit Standard Industrial
    * Classification (SIC) code identifying activities of the
    * company.
    **/
   AQP("Dun and Bradstreet Canada's 8 digit Standard Industrial"),

   /**
    * Activite Principale Exercee (APE) identifier
    * 
    * The French industry code for the main activity of a
    * company.
    **/
   AQQ("Activite Principale Exercee (APE) identifier"),

   /**
    * Dun and Bradstreet US 8 digit Standard Industrial
    * 
    * Classification (SIC) code
    * Dun and Bradstreet United States' 8 digit Standard
    * Industrial Classification (SIC) code identifying
    * activities of the company.
    **/
   AQR("Dun and Bradstreet US 8 digit Standard Industrial"),

   /**
    * Nomenclature Activity Classification Economy (NACE)
    * 
    * identifier
    * A European industry classification code used to identify
    * the activity of a company.
    **/
   AQS("Nomenclature Activity Classification Economy (NACE)"),

   /**
    * Norme Activite Francaise (NAF) identifier
    * 
    * A French industry classification code assigned by the
    * French government to identify the activity of a company.
    **/
   AQT("Norme Activite Francaise (NAF) identifier"),

   /**
    * Registered contractor activity type
    * 
    * Reference number identifying the type of registered
    * contractor activity.
    **/
   AQU("Registered contractor activity type"),

   /**
    * Statistic Bundes Amt (SBA) identifier
    * 
    * A German industry classification code issued by
    * Statistic Bundes Amt (SBA) to identify the activity of a
    * company.
    **/
   AQV("Statistic Bundes Amt (SBA) identifier"),

   /**
    * State or province assigned entity identification
    * 
    * Reference number of an entity assigned by a state or
    * province.
    **/
   AQW("State or province assigned entity identification"),

   /**
    * Institute of Security and Future Market Development (ISFMD)
    * 
    * serial number
    * A number used to identify a public but not publicly
    * traded company.
    **/
   AQX("Institute of Security and Future Market Development (ISFMD)"),

   /**
    * File identification number
    * 
    * A number assigned to identify a file.
    **/
   AQY("File identification number"),

   /**
    * Bankruptcy procedure number
    * 
    * A number identifying a bankruptcy procedure.
    **/
   AQZ("Bankruptcy procedure number"),

   /**
    * National government business identification number
    * 
    * A business identification number which is assigned by a
    * national government.
    **/
   ARA("National government business identification number"),

   /**
    * Prior Data Universal Number System (DUNS) number
    * 
    * A previously assigned Data Universal Number System
    * (DUNS) number.
    **/
   ARB("Prior Data Universal Number System (DUNS) number"),

   /**
    * Companies Registry Office (CRO) number
    * 
    * Identifies the reference number assigned by the
    * Companies Registry Office (CRO).
    **/
   ARC("Companies Registry Office (CRO) number"),

   /**
    * Costa Rican judicial number
    * 
    * A number assigned by the government to a business in
    * Costa Rica.
    **/
   ARD("Costa Rican judicial number"),

   /**
    * Numero de Identificacion Tributaria (NIT)
    * 
    * A number assigned by the government to a business in
    * some Latin American countries.
    **/
   ARE("Numero de Identificacion Tributaria (NIT)"),

   /**
    * Patron number
    * 
    * A number assigned by the government to a business in
    * some Latin American countries. Note that "Patron" is a
    * Spanish word, it is not a person who gives financial or
    * other support.
    **/
   ARF("Patron number"),

   /**
    * Registro Informacion Fiscal (RIF) number
    * 
    * A number assigned by the government to a business in
    * some Latin American countries.
    **/
   ARG("Registro Informacion Fiscal (RIF) number"),

   /**
    * Registro Unico de Contribuyente (RUC) number
    * 
    * A number assigned by the government to a business in
    * some Latin American countries.
    **/
   ARH("Registro Unico de Contribuyente (RUC) number"),

   /**
    * Tokyo SHOKO Research (TSR) business identifier
    * 
    * A number assigned to a business by TSR.
    **/
   ARI("Tokyo SHOKO Research (TSR) business identifier"),

   /**
    * Personal identity card number
    * 
    * An identity card number assigned to a person.
    **/
   ARJ("Personal identity card number"),

   /**
    * Systeme Informatique pour le Repertoire des ENtreprises
    * 
    * (SIREN) number
    * An identification number known as a SIREN assigned to a
    * business in France.
    **/
   ARK("Systeme Informatique pour le Repertoire des ENtreprises"),

   /**
    * Systeme Informatique pour le Repertoire des ETablissements
    * 
    * (SIRET) number
    * An identification number known as a SIRET assigned to a
    * business location in France.
    **/
   ARL("Systeme Informatique pour le Repertoire des ETablissements"),

   /**
    * Publication issue number
    * 
    * A number assigned to identify a publication issue.
    **/
   ARM("Publication issue number"),

   /**
    * Original filing number
    * 
    * A number assigned to the original filing.
    **/
   ARN("Original filing number"),

   /**
    * Document page identifier
    * 
    * [1212] To identify a page number.
    **/
   ARO("Document page identifier"),

   /**
    * Public filing registration number
    * 
    * A number assigned at the time of registration of a
    * public filing.
    **/
   ARP("Public filing registration number"),

   /**
    * Regiristo Federal de Contribuyentes
    * 
    * A federal tax identification number assigned by the
    * Mexican tax authority.
    **/
   ARQ("Regiristo Federal de Contribuyentes"),

   /**
    * Social security number
    * 
    * An identification number assigned to an individual by
    * the social security administration.
    **/
   ARR("Social security number"),

   /**
    * Document volume number
    * 
    * The number of a document volume.
    **/
   ARS("Document volume number"),

   /**
    * Book number
    * 
    * A number assigned to identify a book.
    **/
   ART("Book number"),

   /**
    * Stock exchange company identifier
    * 
    * A reference assigned by the stock exchange to a company.
    **/
   ARU("Stock exchange company identifier"),

   /**
    * Imputation account
    * 
    * An account to which an amount is to be posted.
    **/
   ARV("Imputation account"),

   /**
    * Financial phase reference
    * 
    * A reference which identifies a specific financial phase.
    **/
   ARW("Financial phase reference"),

   /**
    * Technical phase reference
    * 
    * A reference which identifies a specific technical phase.
    **/
   ARX("Technical phase reference"),

   /**
    * Prior contractor registration number
    * 
    * A previous reference number used to identify a
    * contractor.
    **/
   ARY("Prior contractor registration number"),

   /**
    * Stock adjustment number
    * 
    * A number identifying a stock adjustment.
    **/
   ARZ("Stock adjustment number"),

   /**
    * Dispensation reference
    * 
    * A reference number assigned to an official exemption
    * from a law or obligation.
    **/
   ASA("Dispensation reference"),

   /**
    * Investment reference number
    * 
    * A reference to a specific investment.
    **/
   ASB("Investment reference number"),

   /**
    * Assuming company
    * 
    * A number that identifies an assuming company.
    **/
   ASC("Assuming company"),

   /**
    * Budget chapter
    * 
    * A reference to the chapter in a budget.
    **/
   ASD("Budget chapter"),

   /**
    * Duty free products security number
    * 
    * A security number allocated for duty free products.
    **/
   ASE("Duty free products security number"),

   /**
    * Duty free products receipt authorisation number
    * 
    * Authorisation number allocated for the receipt of duty
    * free products.
    **/
   ASF("Duty free products receipt authorisation number"),

   /**
    * Party information message reference
    * 
    * Reference identifying a party information message.
    **/
   ASG("Party information message reference"),

   /**
    * Formal statement reference
    * 
    * A reference to a formal statement.
    **/
   ASH("Formal statement reference"),

   /**
    * Proof of delivery reference number
    * 
    * A reference number identifying a proof of delivery which
    * is generated by the goods recipient.
    **/
   ASI("Proof of delivery reference number"),

   /**
    * Supplier's credit claim reference number
    * 
    * A reference number identifying a supplier's credit
    * claim.
    **/
   ASJ("Supplier's credit claim reference number"),

   /**
    * Picture of actual product
    * 
    * Reference identifying the picture of an actual product.
    **/
   ASK("Picture of actual product"),

   /**
    * Picture of a generic product
    * 
    * Reference identifying a picture of a generic product.
    **/
   ASL("Picture of a generic product"),

   /**
    * Trading partner identification number
    * 
    * Code specifying an identification assigned to an entity
    * with whom one conducts trade.
    **/
   ASM("Trading partner identification number"),

   /**
    * Prior trading partner identification number
    * 
    * Code specifying an identification number previously
    * assigned to a trading partner.
    **/
   ASN("Prior trading partner identification number"),

   /**
    * Password
    * 
    * Code used for authentication purposes.
    **/
   ASO("Password"),

   /**
    * Formal report number
    * 
    * A number uniquely identifying a formal report.
    **/
   ASP("Formal report number"),

   /**
    * Fund account number
    * 
    * Account number of fund.
    **/
   ASQ("Fund account number"),

   /**
    * Safe custody number
    * 
    * The number of a file or portfolio kept for safe custody
    * on behalf of clients.
    **/
   ASR("Safe custody number"),

   /**
    * Master account number
    * 
    * A reference number identifying a master account.
    **/
   ASS("Master account number"),

   /**
    * Group reference number
    * 
    * The reference number identifying a group.
    **/
   AST("Group reference number"),

   /**
    * Accounting transmission number
    * 
    * A number used to identify the transmission of an
    * accounting book entry.
    **/
   ASU("Accounting transmission number"),

   /**
    * Product data file number
    * 
    * The number of a product data file.
    **/
   ASV("Product data file number"),

   /**
    * Cadastro Geral do Contribuinte (CGC)
    * 
    * Brazilian taxpayer number.
    **/
   ASW("Cadastro Geral do Contribuinte (CGC)"),

   /**
    * Foreign resident identification number
    * 
    * Number assigned by a government agency to identify a
    * foreign resident.
    **/
   ASX("Foreign resident identification number"),

   /**
    * CD-ROM
    * 
    * Identity number of the Compact Disk Read Only Memory
    * (CD-ROM).
    **/
   ASY("CD-ROM"),

   /**
    * Physical medium
    * 
    * Identifies the physical medium.
    **/
   ASZ("Physical medium"),

   /**
    * Financial cancellation reference number
    * 
    * Reference number of a financial cancellation.
    **/
   ATA("Financial cancellation reference number"),

   /**
    * Purchase for export Customs agreement number
    * 
    * A number assigned by a Customs authority allowing the
    * purchase of goods free of tax because they are to be
    * exported immediately after the purchase.
    **/
   ATB("Purchase for export Customs agreement number"),

   /**
    * Judgment number
    * 
    * A reference number identifying the legal decision.
    **/
   ATC("Judgment number"),

   /**
    * Secretariat number
    * 
    * A reference number identifying a secretariat.
    **/
   ATD("Secretariat number"),

   /**
    * Previous banking status message reference
    * 
    * Message reference number of the previous banking status
    * message being responded to.
    **/
   ATE("Previous banking status message reference"),

   /**
    * Last received banking status message reference
    * 
    * Reference number of the latest received banking status
    * message.
    **/
   ATF("Last received banking status message reference"),

   /**
    * Bank's documentary procedure reference
    * 
    * Reference allocated by the bank to a documentary
    * procedure.
    **/
   ATG("Bank's documentary procedure reference"),

   /**
    * Customer's documentary procedure reference
    * 
    * Reference allocated by a customer to a documentary
    * procedure.
    **/
   ATH("Customer's documentary procedure reference"),

   /**
    * Safe deposit box number
    * 
    * Number of the safe deposit box.
    **/
   ATI("Safe deposit box number"),

   /**
    * Receiving Bankgiro number
    * 
    * Number of the receiving Bankgiro.
    **/
   ATJ("Receiving Bankgiro number"),

   /**
    * Sending Bankgiro number
    * 
    * Number of the sending Bankgiro.
    **/
   ATK("Sending Bankgiro number"),

   /**
    * Bankgiro reference
    * 
    * Reference of the Bankgiro.
    **/
   ATL("Bankgiro reference"),

   /**
    * Guarantee number
    * 
    * Number of a guarantee.
    **/
   ATM("Guarantee number"),

   /**
    * Collection instrument number
    * 
    * To identify the number of an instrument used to remit
    * funds to a beneficiary.
    **/
   ATN("Collection instrument number"),

   /**
    * Converted Postgiro number
    * 
    * To identify the reference number of a giro payment
    * having been converted to a Postgiro account.
    **/
   ATO("Converted Postgiro number"),

   /**
    * Cost centre alignment number
    * 
    * Number used in the financial management process to align
    * cost allocations.
    **/
   ATP("Cost centre alignment number"),

   /**
    * Kamer Van Koophandel (KVK) number
    * 
    * An identification number assigned by the Dutch Chamber
    * of Commerce to a business in the Netherlands.
    **/
   ATQ("Kamer Van Koophandel (KVK) number"),

   /**
    * Institut Belgo-Luxembourgeois de Codification (IBLC) number
    * 
    * An identification number assigned by the Luxembourg
    * National Bank to a business in Luxembourg.
    **/
   ATR("Institut Belgo-Luxembourgeois de Codification (IBLC) number"),

   /**
    * External object reference
    * 
    * A reference identifying an external object.
    **/
   ATS("External object reference"),

   /**
    * Exceptional transport authorisation number
    * 
    * Authorisation number for exceptional transport (using
    * specific equipment, out of gauge, materials and/or
    * specific routing).
    **/
   ATT("Exceptional transport authorisation number"),

   /**
    * Clave Unica de Identificacion Tributaria (CUIT)
    * 
    * Tax identification number in Argentina.
    **/
   ATU("Clave Unica de Identificacion Tributaria (CUIT)"),

   /**
    * Registro Unico Tributario (RUT)
    * 
    * Tax identification number in Chile.
    **/
   ATV("Registro Unico Tributario (RUT)"),

   /**
    * Flat rack container bundle identification number
    * 
    * Reference number assigned to a bundle of flat rack
    * containers.
    **/
   ATW("Flat rack container bundle identification number"),

   /**
    * Transport equipment acceptance order reference
    * 
    * Reference number assigned to an order to accept
    * transport equipment that is to be delivered by an inland
    * carrier to a specified facility.
    **/
   ATX("Transport equipment acceptance order reference"),

   /**
    * Transport equipment release order reference
    * 
    * Reference number assigned to an order to release
    * transport equipment which is to be picked up by an
    * inland carrier from a specified facility.
    **/
   ATY("Transport equipment release order reference"),

   /**
    * Ship's stay reference number
    * 
    * (1099) Reference number assigned by a port authority to
    * the stay of a vessel in the port.
    **/
   ATZ("Ship's stay reference number"),

   /**
    * Authorization to meet competition number
    * 
    * A number assigned by a requestor to an offer incoming
    * following request for quote.
    **/
   AU("Authorization to meet competition number"),

   /**
    * Place of positioning reference
    * 
    * Identifies the reference pertaining to the place of
    * positioning.
    **/
   AUA("Place of positioning reference"),

   /**
    * Party reference
    * 
    * The reference to a party.
    **/
   AUB("Party reference"),

   /**
    * Issued prescription identification
    * 
    * The identification of the issued prescription.
    **/
   AUC("Issued prescription identification"),

   /**
    * Collection reference
    * 
    * A reference identifying a collection.
    **/
   AUD("Collection reference"),

   /**
    * Travel service
    * 
    * Reference identifying a travel service.
    **/
   AUE("Travel service"),

   /**
    * Consignment stock contract
    * 
    * Reference identifying a consignment stock contract.
    **/
   AUF("Consignment stock contract"),

   /**
    * Importer's letter of credit reference
    * 
    * Letter of credit reference issued by importer.
    **/
   AUG("Importer's letter of credit reference"),

   /**
    * Performed prescription identification
    * 
    * The identification of the prescription that has been
    * carried into effect.
    **/
   AUH("Performed prescription identification"),

   /**
    * Image reference
    * 
    * A reference number identifying an image.
    **/
   AUI("Image reference"),

   /**
    * Proposed purchase order reference number
    * 
    * A reference number assigned to a proposed purchase
    * order.
    **/
   AUJ("Proposed purchase order reference number"),

   /**
    * Application for financial support reference number
    * 
    * Reference number assigned to an application for
    * financial support.
    **/
   AUK("Application for financial support reference number"),

   /**
    * Manufacturing quality agreement number
    * 
    * Reference number of a manufacturing quality agreement.
    **/
   AUL("Manufacturing quality agreement number"),

   /**
    * Software editor reference
    * 
    * Reference identifying the software editor.
    **/
   AUM("Software editor reference"),

   /**
    * Software reference
    * 
    * Reference identifying the software.
    **/
   AUN("Software reference"),

   /**
    * Software quality reference
    * 
    * Reference allocated to the software by a quality
    * assurance agency.
    **/
   AUO("Software quality reference"),

   /**
    * Consolidated orders' reference
    * 
    * A reference number to identify orders which have been,
    * or shall be consolidated.
    **/
   AUP("Consolidated orders' reference"),

   /**
    * Customs binding ruling number
    * 
    * Binding ruling number issued by customs.
    **/
   AUQ("Customs binding ruling number"),

   /**
    * Customs non-binding ruling number
    * 
    * Non-binding ruling number issued by customs.
    **/
   AUR("Customs non-binding ruling number"),

   /**
    * Delivery route reference
    * 
    * A reference to the route of the delivery.
    **/
   AUS("Delivery route reference"),

   /**
    * Net area supplier reference
    * 
    * A reference identifying a supplier within a net area.
    **/
   AUT("Net area supplier reference"),

   /**
    * Time series reference
    * 
    * Reference to a time series.
    **/
   AUU("Time series reference"),

   /**
    * Connecting point to central grid
    * 
    * Reference to a connecting point to a central grid.
    **/
   AUV("Connecting point to central grid"),

   /**
    * Marketing plan identification number (MPIN)
    * 
    * Number identifying a marketing plan.
    **/
   AUW("Marketing plan identification number (MPIN)"),

   /**
    * Entity reference number, previous
    * 
    * The previous reference number assigned to an entity.
    **/
   AUX("Entity reference number, previous"),

   /**
    * International Standard Industrial Classification (ISIC)
    * 
    * code
    * A code specifying an international standard industrial
    * classification.
    **/
   AUY("International Standard Industrial Classification (ISIC)"),

   /**
    * Customs pre-approval ruling number
    * 
    * Pre-approval ruling number issued by Customs.
    **/
   AUZ("Customs pre-approval ruling number"),

   /**
    * Account payable number
    * 
    * Reference number assigned by accounts payable department
    * to the account of a specific creditor.
    **/
   AV("Account payable number"),

   /**
    * First financial institution's transaction reference
    * 
    * Identifies the reference given to the individual
    * transaction by the financial institution that is the
    * transaction's point of entry into the interbank
    * transaction chain.
    **/
   AVA("First financial institution's transaction reference"),

   /**
    * Product characteristics directory
    * 
    * A reference to a product characteristics directory.
    **/
   AVB("Product characteristics directory"),

   /**
    * Supplier's customer reference number
    * 
    * A number, assigned by a supplier, to reference a
    * customer.
    **/
   AVC("Supplier's customer reference number"),

   /**
    * Inventory report request number
    * 
    * Reference number assigned to a request for an inventory
    * report.
    **/
   AVD("Inventory report request number"),

   /**
    * Metering point
    * 
    * Reference to a metering point.
    **/
   AVE("Metering point"),

   /**
    * Passenger reservation number
    * 
    * Number assigned by the travel supplier to identify the
    * passenger reservation.
    **/
   AVF("Passenger reservation number"),

   /**
    * Slaughterhouse approval number
    * 
    * Veterinary licence number allocated by a national
    * authority to a slaughterhouse.
    **/
   AVG("Slaughterhouse approval number"),

   /**
    * Meat cutting plant approval number
    * 
    * Veterinary licence number allocated by a national
    * authority to a meat cutting plant.
    **/
   AVH("Meat cutting plant approval number"),

   /**
    * Customer travel service identifier
    * 
    * A reference identifying a travel service to a customer.
    **/
   AVI("Customer travel service identifier"),

   /**
    * Export control classification number
    * 
    * Number identifying the classification of goods covered
    * by an export licence.
    **/
   AVJ("Export control classification number"),

   /**
    * Broker reference 3
    * 
    * Third reference of a broker.
    **/
   AVK("Broker reference 3"),

   /**
    * Consignment information
    * 
    * Code identifying that the reference number given applies
    * to the consignment information segment group in the
    * referred message .
    **/
   AVL("Consignment information"),

   /**
    * Goods item information
    * 
    * Code identifying that the reference number given applies
    * to the goods item information segment group in the
    * referred message.
    **/
   AVM("Goods item information"),

   /**
    * Dangerous Goods information
    * 
    * Code identifying that the reference number given applies
    * to the dangerous goods information segment group in the
    * referred message.
    **/
   AVN("Dangerous Goods information"),

   /**
    * Pilotage services exemption number
    * 
    * Number identifying the permit to not use pilotage
    * services.
    **/
   AVO("Pilotage services exemption number"),

   /**
    * Person registration number
    * 
    * A number assigned to an individual.
    **/
   AVP("Person registration number"),

   /**
    * Place of packing approval number
    * 
    * Approval Number of the place where goods are packaged.
    **/
   AVQ("Place of packing approval number"),

   /**
    * Original Mandate Reference
    * 
    * Reference to a specific related original mandate given
    * by the relevant party for underlying business or action
    * in case of reference or mandate change.
    **/
   AVR("Original Mandate Reference"),

   /**
    * Mandate Reference
    * 
    * Reference to a specific mandate given by the relevant
    * party for underlying business or action.
    **/
   AVS("Mandate Reference"),

   /**
    * Reservation station indentifier
    * 
    * Reference to the station where a reservation was made.
    **/
   AVT("Reservation station indentifier"),

   /**
    * Unique goods shipment identifier
    * 
    * Unique identifier assigned to a shipment of goods
    * linking trade, tracking and transport information.
    **/
   AVU("Unique goods shipment identifier"),

   /**
    * Framework Agreement Number
    * 
    * A reference to an agreement between one or more
    * contracting authorities and one or more economic
    * operators, the purpose of which is to establish the
    * terms governing contracts to be awarded during a given
    * period, in particular with regard to price and, where
    * appropriate, the quantity envisaged.
    **/
   AVV("Framework Agreement Number"),

   /**
    * Hash value
    * 
    * Contains the hash value of a related document.
    **/
   AVW("Hash value"),

   /**
    * Movement reference number
    * 
    * Number assigned by customs referencing receipt of an
    * Entry Summary Declaration.
    **/
   AVX("Movement reference number"),

   /**
    * Economic Operators Registration and Identification Number
    * 
    * (EORI)
    * Number assigned by an authority to an economic operator.
    **/
   AVY("Economic Operators Registration and Identification Number"),

   /**
    * Local Reference Number
    * 
    * Number assigned by a national customs authority to an
    * Entry Summary Declaration.
    **/
   AVZ("Local Reference Number"),

   /**
    * Rate code number
    * 
    * Number assigned by a buyer to rate a product.
    **/
   AWA("Rate code number"),

   /**
    * Air waybill number
    * 
    * Reference number assigned to an air waybill, see: 1001 =
    * 740.
    **/
   AWB("Air waybill number"),

   /**
    * Documentary credit amendment number
    * 
    * Number of the amendment of the documentary credit.
    **/
   AWC("Documentary credit amendment number"),

   /**
    * Advising bank's reference
    * 
    * Reference number of the advising bank.
    **/
   AWD("Advising bank's reference"),

   /**
    * Cost centre
    * 
    * A number identifying a cost centre.
    **/
   AWE("Cost centre"),

   /**
    * Work item quantity determination
    * 
    * A reference assigned to a work item quantity
    * determination.
    **/
   AWF("Work item quantity determination"),

   /**
    * Internal data process number
    * 
    * A number identifying an internal data process.
    **/
   AWG("Internal data process number"),

   /**
    * Category of work reference
    * 
    * A reference identifying a category of work.
    **/
   AWH("Category of work reference"),

   /**
    * Policy form number
    * 
    * Number assigned to a policy form.
    **/
   AWI("Policy form number"),

   /**
    * Net area
    * 
    * Reference to an area of a net.
    **/
   AWJ("Net area"),

   /**
    * Service provider
    * 
    * Reference of the service provider.
    **/
   AWK("Service provider"),

   /**
    * Error position
    * 
    * Reference to the position of an error in a message.
    **/
   AWL("Error position"),

   /**
    * Service category reference
    * 
    * Reference identifying the service category.
    **/
   AWM("Service category reference"),

   /**
    * Connected location
    * 
    * Reference of a connected location.
    **/
   AWN("Connected location"),

   /**
    * Related party
    * 
    * Reference of a related party.
    **/
   AWO("Related party"),

   /**
    * Latest accounting entry record reference
    * 
    * Code identifying the reference of the latest accounting
    * entry record.
    **/
   AWP("Latest accounting entry record reference"),

   /**
    * Accounting entry
    * 
    * Accounting entry to which this item is related.
    **/
   AWQ("Accounting entry"),

   /**
    * Document reference, original
    * 
    * The original reference of a document.
    **/
   AWR("Document reference, original"),

   /**
    * Hygienic Certificate number, national
    * 
    * Nationally set Hygienic Certificate number, such as
    * sanitary, epidemiologic.
    **/
   AWS("Hygienic Certificate number, national"),

   /**
    * Administrative Reference Code
    * 
    * Reference number assigned by Customs to a ‘shipment of
    * excise goods’.
    **/
   AWT("Administrative Reference Code"),

   /**
    * Pick-up sheet number
    * 
    * Reference number assigned to a pick-up sheet.
    **/
   AWU("Pick-up sheet number"),

   /**
    * Phone number
    * 
    * A sequence of digits used to call from one telephone
    * line to another in a public telephone network.
    **/
   AWV("Phone number"),

   /**
    * Beginning meter reading actual
    * 
    * Meter reading at the beginning of an invoicing period.
    **/
   BA("Beginning meter reading actual"),

   /**
    * Buyer's contract number
    * 
    * Reference number assigned by buyer to a contract.
    **/
   BC("Buyer's contract number"),

   /**
    * Bid number
    * 
    * Number assigned by a submitter of a bid to his bid.
    **/
   BD("Bid number"),

   /**
    * Beginning meter reading estimated
    * 
    * Meter reading at the beginning of an invoicing period
    * where an actual reading is not available.
    **/
   BE("Beginning meter reading estimated"),

   /**
    * House bill of lading number
    * 
    * [1039] Reference number assigned to a house bill of
    * lading.
    **/
   BH("House bill of lading number"),

   /**
    * Bill of lading number
    * 
    * Reference number assigned to a bill of lading, see: 1001
    * = 705.
    **/
   BM("Bill of lading number"),

   /**
    * Consignment identifier, carrier assigned
    * 
    * [1016] Reference number assigned by a carrier of its
    * agent to identify a specific consignment such as a
    * booking reference number when cargo space is reserved
    * prior to loading.
    **/
   BN("Consignment identifier, carrier assigned"),

   /**
    * Blanket order number
    * 
    * Reference number assigned by the order issuer to a
    * blanket order.
    **/
   BO("Blanket order number"),

   /**
    * Broker or sales office number
    * 
    * A number that identifies a broker or sales office.
    **/
   BR("Broker or sales office number"),

   /**
    * Batch number/lot number
    * 
    * [7338] Reference number assigned by manufacturer to a
    * series of similar products or goods produced under
    * similar conditions.
    **/
   BT("Batch number/lot number"),

   /**
    * Blended with number
    * 
    * The batch/lot/package number a product is blended with.
    **/
   BW("Blended with number"),

   /**
    * IATA Cargo Agent CASS Address number
    * 
    * Code issued by IATA to identify agent locations for CASS
    * billing purposes.
    **/
   CAS("IATA Cargo Agent CASS Address number"),

   /**
    * Matching of entries, balanced
    * 
    * Reference to a balanced matching of entries.
    **/
   CAT("Matching of entries, balanced"),

   /**
    * Entry flagging
    * 
    * Reference to a flagging of entries.
    **/
   CAU("Entry flagging"),

   /**
    * Matching of entries, unbalanced
    * 
    * Reference to an unbalanced matching of entries.
    **/
   CAV("Matching of entries, unbalanced"),

   /**
    * Document reference, internal
    * 
    * Internal reference to a document.
    **/
   CAW("Document reference, internal"),

   /**
    * European Value Added Tax identification
    * 
    * Value Added Tax identification number according to
    * European regulation.
    **/
   CAX("European Value Added Tax identification"),

   /**
    * Cost accounting document
    * 
    * The reference to a cost accounting document.
    **/
   CAY("Cost accounting document"),

   /**
    * Grid operator's customer reference number
    * 
    * A number, assigned by a grid operator, to reference a
    * customer.
    **/
   CAZ("Grid operator's customer reference number"),

   /**
    * Ticket control number
    * 
    * Reference giving access to all the details associated
    * with the ticket.
    **/
   CBA("Ticket control number"),

   /**
    * Credit note number
    * 
    * [1113] Reference number assigned to a credit note.
    **/
   CD("Credit note number"),

   /**
    * Ceding company
    * 
    * Company selling obligations to a third party.
    **/
   CEC("Ceding company"),

   /**
    * Consignee's further order
    * 
    * Reference of an order given by the consignee after
    * departure of the means of transport.
    **/
   CFE("Consignee's further order"),

   /**
    * Consignor's further order
    * 
    * Reference of an order given by the consignor after
    * departure of the means of transport.
    **/
   CFO("Consignor's further order"),

   /**
    * Consignee's order number
    * 
    * A number that identifies a consignee's order.
    **/
   CG("Consignee's order number"),

   /**
    * Customer catalogue number
    * 
    * Number identifying a catalogue for customer's usage.
    **/
   CH("Customer catalogue number"),

   /**
    * Cheque number
    * 
    * Unique number assigned to one specific cheque.
    **/
   CK("Cheque number"),

   /**
    * Checking number
    * 
    * Number assigned by checking party to one specific check
    * action.
    **/
   CKN("Checking number"),

   /**
    * Credit memo number
    * 
    * Reference number assigned by issuer to a credit memo.
    **/
   CM("Credit memo number"),

   /**
    * Road consignment note number
    * 
    * Reference number assigned to a road consignment note,
    * see: 1001 = 730.
    **/
   CMR("Road consignment note number"),

   /**
    * Carrier's reference number
    * 
    * Reference number assigned by carrier to a consignment.
    **/
   CN("Carrier's reference number"),

   /**
    * Charges note document attachment indicator
    * 
    * [1070] Indication that a charges note has been
    * established and attached to a transport contract
    * document or not.
    **/
   CNO("Charges note document attachment indicator"),

   /**
    * Call off order number
    * 
    * A number that identifies a call off order.
    **/
   COF("Call off order number"),

   /**
    * Condition of purchase document number
    * 
    * Reference number identifying the conditions of purchase
    * relevant to a purchase.
    **/
   CP("Condition of purchase document number"),

   /**
    * Customer reference number
    * 
    * Reference number assigned by the customer to a
    * transaction.
    **/
   CR("Customer reference number"),

   /**
    * Transport means journey identifier
    * 
    * [8028] To identify a journey of a means of transport,
    * for example voyage number, flight number, trip number.
    **/
   CRN("Transport means journey identifier"),

   /**
    * Condition of sale document number
    * 
    * Reference number identifying the conditions of sale
    * relevant to a sale.
    **/
   CS("Condition of sale document number"),

   /**
    * Team assignment number
    * 
    * Team number assigned to a group that is responsible for
    * working a particular transaction.
    **/
   CST("Team assignment number"),

   /**
    * Contract number
    * 
    * [1296] Reference number of a contract concluded between
    * parties.
    **/
   CT("Contract number"),

   /**
    * Consignment identifier, consignor assigned
    * 
    * [1140] Reference number assigned by the consignor to
    * identify a particular consignment.
    **/
   CU("Consignment identifier, consignor assigned"),

   /**
    * Container operators reference number
    * 
    * Reference number assigned by the party operating or
    * controlling the transport container to a transaction or
    * consignment.
    **/
   CV("Container operators reference number"),

   /**
    * Package number
    * 
    * (7070) Reference number identifying a package or carton
    * within a consignment.
    **/
   CW("Package number"),

   /**
    * Cooperation contract number
    * 
    * Number issued by a party concerned given to a contract
    * on cooperation of two or more parties.
    **/
   CZ("Cooperation contract number"),

   /**
    * Deferment approval number
    * 
    * Number assigned by authorities to a party to approve
    * deferment of payment of tax or duties.
    **/
   DA("Deferment approval number"),

   /**
    * Debit account number
    * 
    * Reference number assigned by issuer to a debit account.
    **/
   DAN("Debit account number"),

   /**
    * Buyer's debtor number
    * 
    * Reference number assigned to a debtor.
    **/
   DB("Buyer's debtor number"),

   /**
    * Distributor invoice number
    * 
    * Reference number assigned by issuer to a distributor
    * invoice.
    **/
   DI("Distributor invoice number"),

   /**
    * Debit note number
    * 
    * [1117] Reference number assigned by issuer to a debit
    * note.
    **/
   DL("Debit note number"),

   /**
    * Document identifier
    * 
    * [1004] Reference number identifying a specific document.
    **/
   DM("Document identifier"),

   /**
    * Delivery note number
    * 
    * [1033] Reference number assigned by the issuer to a
    * delivery note.
    **/
   DQ("Delivery note number"),

   /**
    * Dock receipt number
    * 
    * Number of the cargo receipt submitted when cargo is
    * delivered to a marine terminal.
    **/
   DR("Dock receipt number"),

   /**
    * Ending meter reading actual
    * 
    * Meter reading at the end of an invoicing period.
    **/
   EA("Ending meter reading actual"),

   /**
    * Embargo permit number
    * 
    * Reference number assigned by issuer to an embargo
    * permit.
    **/
   EB("Embargo permit number"),

   /**
    * Export declaration
    * 
    * Number assigned by the exporter to his export
    * declaration number submitted to an authority.
    **/
   ED("Export declaration"),

   /**
    * Ending meter reading estimated
    * 
    * Meter reading at the end of an invoicing period where an
    * actual reading is not available.
    **/
   EE("Ending meter reading estimated"),

   /**
    * Employer's identification number
    * 
    * Number issued by an authority to identify an employer.
    **/
   EI("Employer's identification number"),

   /**
    * Embargo number
    * 
    * Number assigned to specific goods or a family of goods
    * in a classification of embargo measures.
    **/
   EN("Embargo number"),

   /**
    * Equipment number
    * 
    * Number assigned by the manufacturer to specific
    * equipment.
    **/
   EQ("Equipment number"),

   /**
    * Container/equipment receipt number
    * 
    * Number of the Equipment Interchange Receipt issued for
    * full or empty equipment received.
    **/
   ER("Container/equipment receipt number"),

   /**
    * Exporter's reference number
    * 
    * Reference to a party exporting goods.
    **/
   ERN("Exporter's reference number"),

   /**
    * Excess transportation number
    * 
    * (1041) Number assigned to excess transport.
    **/
   ET("Excess transportation number"),

   /**
    * Export permit identifier
    * 
    * [1208] Reference number to identify an export licence or
    * permit.
    **/
   EX("Export permit identifier"),

   /**
    * Fiscal number
    * 
    * Tax payer's number. Number assigned to individual
    * persons as well as to corporates by a public
    * institution; this number is different from the VAT
    * registration number.
    **/
   FC("Fiscal number"),

   /**
    * Consignment identifier, freight forwarder assigned
    * 
    * [1460] Reference number assigned by the freight
    * forwarder to identify a particular consignment.
    **/
   FF("Consignment identifier, freight forwarder assigned"),

   /**
    * File line identifier
    * 
    * Number assigned by the file issuer or sender to identify
    * a specific line.
    **/
   FI("File line identifier"),

   /**
    * Flow reference number
    * 
    * Number given to a usual sender which has regular
    * expeditions of the same goods, to the same destination,
    * defining all general conditions of the transport.
    **/
   FLW("Flow reference number"),

   /**
    * Freight bill number
    * 
    * Reference number assigned by issuing party to a freight
    * bill.
    **/
   FN("Freight bill number"),

   /**
    * Foreign exchange
    * 
    * Exchange of two currencies at an agreed rate.
    **/
   FO("Foreign exchange"),

   /**
    * Final sequence number
    * 
    * A number that identifies the final sequence.
    **/
   FS("Final sequence number"),

   /**
    * Free zone identifier
    * 
    * Identifier to specify the territory of a State where any
    * goods introduced are generally regarded, insofar as
    * import duties and taxes are concerned, as being outside
    * the Customs territory and are not subject to usual
    * Customs control (CCC).
    **/
   FT("Free zone identifier"),

   /**
    * File version number
    * 
    * Number given to a version of an identified file.
    **/
   FV("File version number"),

   /**
    * Foreign exchange contract number
    * 
    * Reference number identifying a foreign exchange
    * contract.
    **/
   FX("Foreign exchange contract number"),

   /**
    * Standard's number
    * 
    * Number to identify a standardization description (e.g.
    * ISO 9375).
    **/
   GA("Standard's number"),

   /**
    * Government contract number
    * 
    * Number assigned to a specific government/public
    * contract.
    **/
   GC("Government contract number"),

   /**
    * Standard's code number
    * 
    * Number to identify a specific parameter within a
    * standardization description (e.g. M5 for screws or DIN
    * A4 for paper).
    **/
   GD("Standard's code number"),

   /**
    * General declaration number
    * 
    * Number of the declaration of incoming goods out of a
    * vessel.
    **/
   GDN("General declaration number"),

   /**
    * Government reference number
    * 
    * A number that identifies a government reference.
    **/
   GN("Government reference number"),

   /**
    * Harmonised system number
    * 
    * Number specifying the goods classification under the
    * Harmonised Commodity Description and Coding System of
    * the Customs Co-operation Council (CCC).
    **/
   HS("Harmonised system number"),

   /**
    * House waybill number
    * 
    * Reference number assigned to a house waybill, see: 1001
    * = 703.
    **/
   HWB("House waybill number"),

   /**
    * Internal vendor number
    * 
    * Number identifying the company-internal vending
    * department/unit.
    **/
   IA("Internal vendor number"),

   /**
    * In bond number
    * 
    * Customs assigned number that is used to control the
    * movement of imported cargo prior to its formal Customs
    * clearing.
    **/
   IB("In bond number"),

   /**
    * IATA cargo agent code number
    * 
    * Code issued by IATA identify each IATA Cargo Agent whose
    * name is entered on the Cargo Agency List.
    **/
   ICA("IATA cargo agent code number"),

   /**
    * Insurance certificate reference number
    * 
    * A number that identifies an insurance certificate
    * reference.
    **/
   ICE("Insurance certificate reference number"),

   /**
    * Insurance contract reference number
    * 
    * A number that identifies an insurance contract
    * reference.
    **/
   ICO("Insurance contract reference number"),

   /**
    * Initial sample inspection report number
    * 
    * Inspection report number given to the initial sample
    * inspection.
    **/
   II("Initial sample inspection report number"),

   /**
    * Internal order number
    * 
    * Number assigned to an order for internal handling/follow
    * up.
    **/
   IL("Internal order number"),

   /**
    * Intermediary broker
    * 
    * A number that identifies an intermediary broker.
    **/
   INB("Intermediary broker"),

   /**
    * Interchange number new
    * 
    * Number assigned by the interchange sender to identify
    * one specific interchange. This number points to the
    * actual interchange.
    **/
   INN("Interchange number new"),

   /**
    * Interchange number old
    * 
    * Number assigned by the interchange sender to identify
    * one specific interchange. This number points to the
    * previous interchange.
    **/
   INO("Interchange number old"),

   /**
    * Import permit identifier
    * 
    * [1107] Reference number to identify an import licence or
    * permit.
    **/
   IP("Import permit identifier"),

   /**
    * Invoice number suffix
    * 
    * A number added at the end of an invoice number.
    **/
   IS("Invoice number suffix"),

   /**
    * Internal customer number
    * 
    * Number assigned by a seller, supplier etc. to identify a
    * customer within his enterprise.
    **/
   IT("Internal customer number"),

   /**
    * Invoice document identifier
    * 
    * [1334] Reference number to identify an invoice.
    **/
   IV("Invoice document identifier"),

   /**
    * Job number
    * 
    * [1043] Identifies a piece of work.
    **/
   JB("Job number"),

   /**
    * Ending job sequence number
    * 
    * A number that identifies the ending job sequence.
    **/
   JE("Ending job sequence number"),

   /**
    * Shipping label serial number
    * 
    * The serial number on a shipping label.
    **/
   LA("Shipping label serial number"),

   /**
    * Loading authorisation identifier
    * 
    * [4092] Identifier assigned to the loading authorisation
    * granted by the forwarding location e.g. railway or
    * airport, when the consignment is subject to traffic
    * limitations.
    **/
   LAN("Loading authorisation identifier"),

   /**
    * Lower number in range
    * 
    * Lower number in a range of numbers.
    **/
   LAR("Lower number in range"),

   /**
    * Lockbox
    * 
    * Type of cash management system offered by financial
    * institutions to provide for collection of customers
    * 'receivables'.
    **/
   LB("Lockbox"),

   /**
    * Letter of credit number
    * 
    * Reference number identifying the letter of credit
    * document.
    **/
   LC("Letter of credit number"),

   /**
    * Document line identifier
    * 
    * [1156] To identify a line of a document.
    **/
   LI("Document line identifier"),

   /**
    * Load planning number
    * 
    * The reference that identifies the load planning number.
    **/
   LO("Load planning number"),

   /**
    * Reservation office identifier
    * 
    * Reference to the office where a reservation was made.
    **/
   LRC("Reservation office identifier"),

   /**
    * Bar coded label serial number
    * 
    * The serial number on a bar code label.
    **/
   LS("Bar coded label serial number"),

   /**
    * Ship notice/manifest number
    * 
    * The number assigned to a ship notice or manifest.
    **/
   MA("Ship notice/manifest number"),

   /**
    * Master bill of lading number
    * 
    * Reference number assigned to a master bill of lading,
    * see: 1001 = 704.
    **/
   MB("Master bill of lading number"),

   /**
    * Manufacturer's part number
    * 
    * Reference number assigned by the manufacturer to his
    * product or part.
    **/
   MF("Manufacturer's part number"),

   /**
    * Meter unit number
    * 
    * Number identifying a unique meter unit.
    **/
   MG("Meter unit number"),

   /**
    * Manufacturing order number
    * 
    * Reference number assigned by manufacturer for a given
    * production quantity of products.
    **/
   MH("Manufacturing order number"),

   /**
    * Message recipient
    * 
    * A number that identifies the message recipient.
    **/
   MR("Message recipient"),

   /**
    * Mailing reference number
    * 
    * Identifies the party designated by the importer to
    * receive certain customs correspondence in lieu of its
    * being mailed directly to the importer.
    **/
   MRN("Mailing reference number"),

   /**
    * Message sender
    * 
    * A number that identifies the message sender.
    **/
   MS("Message sender"),

   /**
    * Manufacturer's material safety data sheet number
    * 
    * A number that identifies a manufacturer's material
    * safety data sheet.
    **/
   MSS("Manufacturer's material safety data sheet number"),

   /**
    * Master air waybill number
    * 
    * Reference number assigned to a master air waybill, see:
    * 1001 = 741.
    **/
   MWB("Master air waybill number"),

   /**
    * North American hazardous goods classification number
    * 
    * Reference to materials designated as hazardous for
    * purposes of transportation in North American commerce.
    **/
   NA("North American hazardous goods classification number"),

   /**
    * Nota Fiscal is a registration number for shipments
    * deliveries within Brazil, issued by the local tax
    * authorities and mandated for each shipment.
    */
   NF("Nota Fiscal"),

   /**
    * Current invoice number
    * 
    * Reference number identifying the current invoice.
    **/
   OH("Current invoice number"),

   /**
    * Previous invoice number
    * 
    * Reference number identifying a previously issued
    * invoice.
    **/
   OI("Previous invoice number"),

   /**
    * Order document identifier, buyer assigned
    * 
    * [1022] Identifier assigned by the buyer to an order.
    **/
   ON("Order document identifier, buyer assigned"),

   /**
    * Original purchase order
    * 
    * Reference to the order previously sent.
    **/
   OP("Original purchase order"),

   /**
    * General order number
    * 
    * Customs number assigned to imported merchandise that has
    * been left unclaimed and subsequently moved to a Customs
    * bonded warehouse for storage.
    **/
   OR("General order number"),

   /**
    * Payer's financial institution account number
    * 
    * Originated company account number (ACH transfer), check,
    * draft or wire.
    **/
   PB("Payer's financial institution account number"),

   /**
    * Production code
    * 
    * Number assigned by the manufacturer to a specified
    * article or batch to identify the manufacturing date etc.
    * for subsequent reference.
    **/
   PC("Production code"),

   /**
    * Promotion deal number
    * 
    * Number assigned by a vendor to a special promotion
    * activity.
    **/
   PD("Promotion deal number"),

   /**
    * Plant number
    * 
    * A number that identifies a plant.
    **/
   PE("Plant number"),

   /**
    * Prime contractor contract number
    * 
    * Reference number assigned by the client to the contract
    * of the prime contractor.
    **/
   PF("Prime contractor contract number"),

   /**
    * Price list version number
    * 
    * A number that identifies the version of a price list.
    **/
   PI("Price list version number"),

   /**
    * Packing list number
    * 
    * [1014] Reference number assigned to a packing list.
    **/
   PK("Packing list number"),

   /**
    * Price list number
    * 
    * Reference number assigned to a price list.
    **/
   PL("Price list number"),

   /**
    * Purchase order response number
    * 
    * Reference number assigned by the seller to an order
    * response.
    **/
   POR("Purchase order response number"),

   /**
    * Purchase order change number
    * 
    * Reference number assigned by a buyer for a revision of a
    * purchase order.
    **/
   PP("Purchase order change number"),

   /**
    * Payment reference
    * 
    * Reference number assigned to a payment.
    **/
   PQ("Payment reference"),

   /**
    * Price quote number
    * 
    * Reference number assigned by the seller to a quote.
    **/
   PR("Price quote number"),

   /**
    * Purchase order number suffix
    * 
    * A number added at the end of a purchase order number.
    **/
   PS("Purchase order number suffix"),

   /**
    * Prior purchase order number
    * 
    * Reference number of a purchase order previously sent to
    * the supplier.
    **/
   PW("Prior purchase order number"),

   /**
    * Payee's financial institution account number
    * 
    * Receiving company account number (ACH transfer), check,
    * draft or wire.
    **/
   PY("Payee's financial institution account number"),

   /**
    * Remittance advice number
    * 
    * A number that identifies a remittance advice.
    **/
   RA("Remittance advice number"),

   /**
    * Rail/road routing code
    * 
    * International Western and Eastern European route code
    * used in all rail organizations and specified in the
    * international tariffs (rail tariffs) known by the
    * customers.
    **/
   RC("Rail/road routing code"),

   /**
    * Railway consignment note number
    * 
    * Reference number assigned to a rail consignment note,
    * see: 1001 = 720.
    **/
   RCN("Railway consignment note number"),

   /**
    * Release number
    * 
    * Reference number assigned to identify a release of a set
    * of rules, conventions, conditions, etc.
    **/
   RE("Release number"),

   /**
    * Consignment receipt identifier
    * 
    * [1150] Reference number assigned to identify a
    * consignment upon its arrival at its destination.
    **/
   REN("Consignment receipt identifier"),

   /**
    * Export reference number
    * 
    * Reference number given to an export shipment.
    **/
   RF("Export reference number"),

   /**
    * Payer's financial institution transit routing No.(ACH
    * 
    * transfers)
    * ODFI (ACH transfer).
    **/
   RR("Payer's financial institution transit routing No.(ACH"),

   /**
    * Payee's financial institution transit routing No.
    * 
    * RDFI Transit routing number (ACH transfer).
    **/
   RT("Payee's financial institution transit routing No."),

   /**
    * Sales person number
    * 
    * Identification number of a sales person.
    **/
   SA("Sales person number"),

   /**
    * Sales region number
    * 
    * A number that identifies a sales region.
    **/
   SB("Sales region number"),

   /**
    * Sales department number
    * 
    * A number that identifies a sales department.
    **/
   SD("Sales department number"),

   /**
    * Serial number
    * 
    * Identification number of an item which distinguishes
    * this specific item out of an number of identical items.
    **/
   SE("Serial number"),

   /**
    * Allocated seat
    * 
    * Reference to a seat allocated to a passenger.
    **/
   SEA("Allocated seat"),

   /**
    * Ship from
    * 
    * A number that identifies a ship from location.
    **/
   SF("Ship from"),

   /**
    * Previous highest schedule number
    * 
    * Number of the latest schedule of a previous period
    * (ODETTE DELINS).
    **/
   SH("Previous highest schedule number"),

   /**
    * SID (Shipper's identifying number for shipment)
    * 
    * A number that identifies the SID (shipper's
    * identification) number for a shipment.
    **/
   SI("SID (Shipper's identifying number for shipment)"),

   /**
    * Sales office number
    * 
    * A number that identifies a sales office.
    **/
   SM("Sales office number"),

   /**
    * Transport equipment seal identifier
    * 
    * [9308] The identification number of a seal affixed to a
    * piece of transport equipment.
    **/
   SN("Transport equipment seal identifier"),

   /**
    * Scan line
    * 
    * A number that identifies a scan line.
    **/
   SP("Scan line"),

   /**
    * Equipment sequence number
    * 
    * (1492) A temporary reference number identifying a
    * particular piece of equipment within a series of pieces
    * of equipment.
    **/
   SQ("Equipment sequence number"),

   /**
    * Shipment reference number
    * 
    * [1065] Reference number assigned to a shipment.
    **/
   SRN("Shipment reference number"),

   /**
    * Sellers reference number
    * 
    * Reference number assigned to a transaction by the
    * seller.
    **/
   SS("Sellers reference number"),

   /**
    * Station reference number
    * 
    * International UIC code assigned to every European rail
    * station (CIM convention).
    **/
   STA("Station reference number"),

   /**
    * Swap order number
    * 
    * Number assigned by the seller to a swap order (see
    * definition of DE 1001, code 229).
    **/
   SW("Swap order number"),

   /**
    * Specification number
    * 
    * Number assigned by the issuer to his specification.
    **/
   SZ("Specification number"),

   /**
    * Trucker's bill of lading
    * 
    * A cargo list/description issued by a motor carrier of
    * freight.
    **/
   TB("Trucker's bill of lading"),

   /**
    * Terminal operator's consignment reference
    * 
    * Reference assigned to a consignment by the terminal
    * operator.
    **/
   TCR("Terminal operator's consignment reference"),

   /**
    * Telex message number
    * 
    * Reference number identifying a telex message.
    **/
   TE("Telex message number"),

   /**
    * Transfer number
    * 
    * An extra number assigned to goods or a container which
    * functions as a reference number or as an authorization
    * number to get the goods or container released from a
    * certain party.
    **/
   TF("Transfer number"),

   /**
    * TIR carnet number
    * 
    * Reference number assigned to a TIR carnet.
    **/
   TI("TIR carnet number"),

   /**
    * Transport instruction number
    * 
    * Reference number identifying a transport instruction.
    **/
   TIN("Transport instruction number"),

   /**
    * Tax exemption licence number
    * 
    * Number assigned by the tax authorities to a party
    * indicating its tax exemption authorization. This number
    * could relate to a specified business type, a specified
    * local area or a class of products.
    **/
   TL("Tax exemption licence number"),

   /**
    * Transaction reference number
    * 
    * Reference applied to a transaction between two or more
    * parties over a defined life cycle; e.g. number applied
    * by importer or broker to obtain release from Customs,
    * may then used to control declaration through final
    * accounting (synonyms: declaration, entry number).
    **/
   TN("Transaction reference number"),

   /**
    * Test report number
    * 
    * Reference number identifying a test report document
    * relevant to the product.
    **/
   TP("Test report number"),

   /**
    * Upper number of range
    * 
    * Upper number in a range of numbers.
    **/
   UAR("Upper number of range"),

   /**
    * Ultimate customer's reference number
    * 
    * The originator's reference number as forwarded in a
    * sequence of parties involved.
    **/
   UC("Ultimate customer's reference number"),

   /**
    * Unique consignment reference number
    * 
    * [1202] Unique reference identifying a particular
    * consignment of goods. Synonym: UCR, UCRN.
    **/
   UCN("Unique consignment reference number"),

   /**
    * United Nations Dangerous Goods identifier
    * 
    * [7124] United Nations Dangerous Goods Identifier (UNDG)
    * is the unique serial number assigned within the United
    * Nations to substances and articles contained in a list
    * of the dangerous goods most commonly carried.
    **/
   UN("United Nations Dangerous Goods identifier"),

   /**
    * Ultimate customer's order number
    * 
    * The originator's order number as forwarded in a sequence
    * of parties involved.
    **/
   UO("Ultimate customer's order number"),

   /**
    * Uniform Resource Identifier
    * 
    * A string of characters used to identify a name of a
    * resource on the worldwide web.
    **/
   URI("Uniform Resource Identifier"),

   /**
    * VAT registration number
    * 
    * Unique number assigned by the relevant tax authority to
    * identify a party for use in relation to Value Added Tax
    * (VAT).
    **/
   VA("VAT registration number"),

   /**
    * Vendor contract number
    * 
    * Number assigned by the vendor to a contract.
    **/
   VC("Vendor contract number"),

   /**
    * Vessel identifier
    * 
    * (8123) Reference identifying a vessel.
    **/
   VM("Vessel identifier"),

   /**
    * Order number (vendor)
    * 
    * Reference number assigned by supplier to a buyer's
    * purchase order.
    **/
   VN("Order number (vendor)"),

   /**
    * Voyage number
    * 
    * (8028) Reference number assigned to the voyage of the
    * vessel.
    **/
   VON("Voyage number"),

   /**
    * Vendor product number
    * 
    * Number assigned by vendor to another manufacturer's
    * product.
    **/
   VP("Vendor product number"),

   /**
    * Vendor ID number
    * 
    * A number that identifies a vendor's identification.
    **/
   VR("Vendor ID number"),

   /**
    * Vendor order number suffix
    * 
    * The suffix for a vendor order number.
    **/
   VS("Vendor order number suffix"),

   /**
    * Motor vehicle identification number
    * 
    * (8213) Reference identifying a motor vehicle used for
    * transport. Normally is the vehicle registration number.
    **/
   VT("Motor vehicle identification number"),

   /**
    * Voucher number
    * 
    * Reference number identifying a voucher.
    **/
   VV("Voucher number"),

   /**
    * Warehouse entry number
    * 
    * Entry number under which imported merchandise was placed
    * in a Customs bonded warehouse.
    **/
   WE("Warehouse entry number"),

   /**
    * Weight agreement number
    * 
    * A number identifying a weight agreement.
    **/
   WM("Weight agreement number"),

   /**
    * Well number
    * 
    * A number assigned to a shaft sunk into the ground.
    **/
   WN("Well number"),

   /**
    * Warehouse receipt number
    * 
    * A number identifying a warehouse receipt.
    **/
   WR("Warehouse receipt number"),

   /**
    * Warehouse storage location number
    * 
    * A number identifying a warehouse storage location.
    **/
   WS("Warehouse storage location number"),

   /**
    * Rail waybill number
    * 
    * The number on a rail waybill.
    **/
   WY("Rail waybill number"),

   /**
    * Company/place registration number
    * 
    * Company registration and place as legally required.
    **/
   XA("Company/place registration number"),

   /**
    * Cargo control number
    * 
    * Reference used to identify and control a carrier and
    * consignment from initial entry into a country until
    * release of the cargo by Customs.
    **/
   XC("Cargo control number"),

   /**
    * Previous cargo control number
    * 
    * Where a consignment is deconsolidated and/or transferred
    * to the control of another carrier or freight forwarder
    * (e.g. housebill, abstract) this references the previous
    * (e.g. master) cargo control number.
    **/
   XP("Previous cargo control number"),

   /**
    * Mutually defined reference number
    * 
    * Number based on party agreement.
    **/
   ZZZ("Mutually defined reference number");

   /** the description for the code. */
   final private String description;

   
   private Reference(String description) {
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
    * @param enumCode the enum code
    * @return the type by code
    */
   public static Reference getByCode(String enumCode) {
      if (isNullOrEmpty(enumCode)) {
         return null;
      }
      return valueOf(enumCode);
   }
   
   @Override
   public String toString() {
      return new StringBuilder().append("[").append(getCode()).append("] ").append(description).toString();
   }
}
