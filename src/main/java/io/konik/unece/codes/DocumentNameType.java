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
package io.konik.unece.codes;

import io.konik.util.KonikEnum;


/**
 * 
 * = The Document Name Code Enumeration.
 * Based on UN/EDIFACT 1001 *Document name code*
 * Version 2013 b
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred1001.htm[UN/EDIFACT 1001 Document name code]
 * 
 */
public enum DocumentNameType {

   /**
    * Certificate providing the values of an analysis.
    */
   _1("Certificate of analysis"),
   /**
    * Certificate certifying the conformity to predefined
    * definitions.
    */
   _2("Certificate of conformity"),
   /**
    * Certificate certifying the quality of goods, services
    * etc.
    */
   _3("Certificate of quality"),
   /**
    * Report providing the results of a test session.
    */
   _4("Test report"),
   /**
    * Report specifying the performance values of products.
    */
   _5("Product performance report"),
   /**
    * Report providing specification values of products.
    */
   _6("Product specification report"),
   /**
    * Reports on events during production process.
    */
   _7("Process data report"),
   /**
    * Document/message describes the test report of the first
    * sample.
    */
   _8("First sample test report"),
   /**
    * A document/message to enable the transmission of
    * information regarding pricing and catalogue details for
    * goods and services offered by a seller to a buyer.
    */
   _9("Price/sales catalogue"),
   /**
    * Document/message providing basic data concerning a
    * party.
    */
   _10("Party information"),
   /**
    * A pre-approved document relating to federal label
    * approval requirements.
    */
   _11("Federal label approval"),
   /**
    * Certificate certifying a specific quality of
    * agricultural products.
    */
   _12("Mill certificate"),
   /**
    * Document/message which evidences the transport of goods
    * by post (e.g. mail, parcel, etc.).
    */
   _13("Post receipt"),
   /**
    * Certificate certifying the weight of goods.
    */
   _14("Weight certificate"),
   /**
    * Document/message specifying the weight of goods.
    */
   _15("Weight list"),
   /**
    * Document by means of which the documentary credit
    * applicant specifies the conditions for the certificate
    * and by whom the certificate is to be issued.
    */
   _16("Certificate"),
   /**
    * Document identifying goods in which the issuing
    * authority expressly certifies that the goods originate
    * in a specific country or part of, or group of countries.
    * It also states the price and/or cost of the goods with
    * the purpose of determining the customs origin.
    */
   _17("Combined certificate of value and origin"),
   /**
    * Specific form of transit declaration issued by the
    * exporter (movement certificate).
    */
   _18("Movement certificate A.TR.1"),
   /**
    * Certificate certifying the quantity of goods, services
    * etc.
    */
   _19("Certificate of quantity"),
   /**
    * Usage of QALITY-message.
    */
   _20("Quality data message"),
   /**
    * Request information based on defined criteria.
    */
   _21("Query"),
   /**
    * Document/message returned as an answer to a question.
    */
   _22("Response to query"),
   /**
    * Information regarding the status of a related message.
    */
   _23("Status information"),
   /**
    * Message/document identifying containers that have been
    * unloaded and then reloaded onto the same means of
    * transport.
    */
   _24("Restow"),
   /**
    * Message/document itemising containers to be discharged
    * from vessel.
    */
   _25("Container discharge list"),
   /**
    * Document/message providing contributions advice used for
    * corporate superannuation schemes.
    */
   _26("Corporate superannuation contributions advice"),
   /**
    * Document/message providing contributions advice used for
    * superannuation schemes which are industry wide.
    */
   _27("Industry superannuation contributions advice"),
   /**
    * Member maintenance message used for corporate
    * superannuation schemes.
    */
   _28("Corporate superannuation member maintenance message"),
   /**
    * Member maintenance message used for industry wide
    * superannuation schemes.
    */
   _29("Industry superannuation member maintenance message"),
   /**
    * Payroll deductions advice used in the life insurance
    * industry.
    */
   _30("Life insurance payroll deductions advice"),
   /**
    * A Message/document requesting to move cargo from one
    * Customs control point to another.
    */
   _31("Underbond request"),
   /**
    * A message/document issuing Customs approval to move
    * cargo from one Customs control point to another.
    */
   _32("Underbond approval"),
   /**
    * Document / message issued by the authority in the
    * exporting country evidencing the sealing of export meat
    * lockers.
    */
   _33("Certificate of sealing of export meat lockers"),
   /**
    * Message identifying the status of cargo.
    */
   _34("Cargo status"),
   /**
    * A message specifying information relating to held
    * inventories.
    */
   _35("Inventory report"),
   /**
    * Official document to identify a person.
    */
   _36("Identity card"),
   /**
    * Document/message in which the competent national
    * authorities provide a declarant with an acceptance or a
    * rejection about a received declaration for European
    * statistical purposes.
    */
   _37("Response to a trade statistics message"),
   /**
    * Official document proving immunisation against certain
    * diseases.
    */
   _38("Vaccination certificate"),
   /**
    * An official document giving permission to travel in
    * foreign countries.
    */
   _39("Passport"),
   /**
    * An official document giving permission to drive a car in
    * a given country.
    */
   _40("Driving licence (national)"),
   /**
    * An official document giving a native of one country
    * permission to drive a vehicle in certain other
    * countries.
    */
   _41("Driving licence (international)"),
   /**
    * A document giving free access to a service.
    */
   _42("Free pass"),
   /**
    * A document giving access to a service for a determined
    * period of time.
    */
   _43("Season ticket"),
   /**
    * (1125) A message to report the transport status and/or
    * change in the transport status (i.e. event) between
    * agreed parties.
    */
   _44("Transport status report"),
   /**
    * (1127) A message to request a transport status report
    * (e.g. through the national multimodal status report
    * message IFSTA).
    */
   _45("Transport status request"),
   /**
    * A banking status document and/or message.
    */
   _46("Banking status"),
   /**
    * Document/message in which a declarant provides
    * information about extra-Community trade of goods
    * required by the body responsible for the collection of
    * trade statistics. Trade by a country in the European
    * Union with a country outside the European Union.
    */
   _47("Extra-Community trade statistical declaration"),
   /**
    * 10385
    * Written instructions relating to dangerous goods and
    * defined in the European Agreement of Dangerous Transport
    * by Road known as ADR (Accord europeen relatif au
    * transport international des marchandises Dangereuses par
    * Route).
    */
   _48("Written instructions in conformance with ADR article number"),
   /**
    * Official certification that damages to the goods to be
    * transported have been discovered.
    */
   _49("Damage certification"),
   /**
    * A validated priced tender.
    */
   _50("Validated priced tender"),
   /**
    * A document providing a response to a previously sent
    * price/sales catalogue.
    */
   _51("Price/sales catalogue response"),
   /**
    * A document providing the result of price negotiations.
    */
   _52("Price negotiation result"),
   /**
    * Document or message to supply advice on a dangerous or
    * hazardous material to industrial customers so as to
    * enable them to take measures to protect their employees
    * and the environment from any potential harmful effects
    * from these material.
    */
   _53("Safety and hazard data sheet"),
   /**
    * A statement of an account containing the booked items as
    * in the ledger of the account servicing financial
    * institution.
    */
   _54("Legal statement of an account"),
   /**
    * A statement from the account servicing financial
    * institution containing items pending to be booked.
    */
   _55("Listing statement of an account"),
   /**
    * Last statement of a period containing the interest
    * calculation and the final balance of the last entry
    * date.
    */
   _56("Closing statement of an account"),
   /**
    * Report on the movement of containers or other items of
    * transport equipment to record physical movement activity
    * and establish the beginning of a rental period.
    */
   _57("Transport equipment on-hire report"),
   /**
    * Report on the movement of containers or other items of
    * transport equipment to record physical movement activity
    * and establish the end of a rental period.
    */
   _58("Transport equipment off-hire report"),
   /**
    * No shortage, surplus or damaged outturn resulting from
    * container vessel unpacking.
    */
   _59("Treatment - nil outturn"),
   /**
    * Movement type indicator: goods are moved under customs
    * control for warehousing due to being time-up.
    */
   _60("Treatment - time-up underbond"),
   /**
    * Movement type indicator: goods are to move by sea under
    * customs control to a customs office where formalities
    * will be completed.
    */
   _61("Treatment - underbond by sea"),
   /**
    * Cargo consists of personal effects.
    */
   _62("Treatment - personal effect"),
   /**
    * Cargo consists of timber.
    */
   _63("Treatment - timber"),
   /**
    * Document/message issued either by a factor to indicate
    * his preliminary credit assessment on a buyer, or by a
    * seller to request a factor's preliminary credit
    * assessment on a buyer.
    */
   _64("Preliminary credit assessment"),
   /**
    * Document/message issued either by a factor to give a
    * credit cover on a buyer, or by a seller to request a
    * factor's credit cover.
    */
   _65("Credit cover"),
   /**
    * Document/message issued by a factor to indicate the
    * money movements of a seller's or another factor's
    * account with him.
    */
   _66("Current account"),
   /**
    * Document/message issued by a party (usually the buyer)
    * to indicate that one or more invoices or one or more
    * credit notes are disputed for payment.
    */
   _67("Commercial dispute"),
   /**
    * Document/message issued by a factor to a seller or to
    * another factor to indicate that the rest of the amounts
    * of one or more invoices uncollectable from buyers are
    * charged back to clear the invoice(s) off the ledger.
    */
   _68("Chargeback"),
   /**
    * Document/message issued by a factor to a seller or to
    * another factor to reassign an invoice or credit note
    * previously assigned to him.
    */
   _69("Reassignment"),
   /**
    * Document message issued by a factor to indicate the
    * movements of invoices, credit notes and payments of a
    * seller's account.
    */
   _70("Collateral account"),
   /**
    * Document/message issued by a creditor to a debtor to
    * request payment of one or more invoices past due.
    */
   _71("Request for payment"),
   /**
    * A message or document issuing permission to unship
    * cargo.
    */
   _72("Unship permit"),
   /**
    * Transmission of one or more statistical definitions.
    */
   _73("Statistical definitions"),
   /**
    * Transmission of one or more items of data or data sets.
    */
   _74("Statistical data"),
   /**
    * Request for one or more items or data sets of
    * statistical data.
    */
   _75("Request for statistical data"),
   /**
    * Document/message to provide split quantities and
    * delivery dates referring to a previous delivery
    * instruction.
    */
   _76("Call-off delivery"),
   /**
    * Message covers information about the consignment status.
    */
   _77("Consignment status report"),
   /**
    * Advice of inventory movements.
    */
   _78("Inventory movement advice"),
   /**
    * Advice of stock on hand.
    */
   _79("Inventory status advice"),
   /**
    * Debit information related to a transaction for goods or
    * services to the relevant party.
    */
   _80("Debit note related to goods or services"),
   /**
    * Document message used to provide credit information
    * related to a transaction for goods or services to the
    * relevant party.
    */
   _81("Credit note related to goods or services"),
   /**
    * Document/message claiming payment for the supply of
    * metered services (e.g., gas, electricity, etc.) supplied
    * to a fixed meter whose consumption is measured over a
    * period of time.
    */
   _82("Metered services invoice"),
   /**
    * Document message for providing credit information
    * related to financial adjustments to the relevant party,
    * e.g., bonuses.
    */
   _83("Credit note related to financial adjustments"),
   /**
    * Document/message for providing debit information related
    * to financial adjustments to the relevant party.
    */
   _84("Debit note related to financial adjustments"),
   /**
    * Message/document identifying a customs manifest. The
    * document itemises a list of cargo prepared by shipping
    * companies from bills of landing and presented to customs
    * for formal report of cargo.
    */
   _85("Customs manifest"),
   /**
    * A document code to indicate that the message being
    * transmitted identifies all short and surplus cargoes
    * off-loaded from a vessel at a specified discharging
    * port.
    */
   _86("Vessel unpack report"),
   /**
    * A document code to indicate that the message being
    * transmitted is summary manifest information for general
    * cargo.
    */
   _87("General cargo summary manifest report"),
   /**
    * A document code to indicate that the message being
    * transmitted is a consignment unpack report only.
    */
   _88("Consignment unpack report"),
   /**
    * Document or message issued by the competent authority in
    * the exporting country evidencing that meat or meat by-
    * products comply with the requirements set by the
    * importing country.
    */
   _89("Meat and meat by-products sanitary certificate"),
   /**
    * Document or message issued by the competent authority in
    * the exporting country evidencing that meat food products
    * comply with the requirements set by the importing
    * country.
    */
   _90("Meat food products sanitary certificate"),
   /**
    * Document or message issued by the competent authority in
    * the exporting country evidencing that poultry products
    * comply with the requirements set by the importing
    * country.
    */
   _91("Poultry sanitary certificate"),
   /**
    * Document or message issued by the competent authority in
    * the exporting country evidencing that horsemeat products
    * comply with the requirements set by the importing
    * country.
    */
   _92("Horsemeat sanitary certificate"),
   /**
    * Document or message issued by the competent authority in
    * the exporting country evidencing that casing products
    * comply with the requirements set by the importing
    * country.
    */
   _93("Casing sanitary certificate"),
   /**
    * Document or message issued by the competent authority in
    * the exporting country evidencing that pharmaceutical
    * products comply with the requirements set by the
    * importing country.
    */
   _94("Pharmaceutical sanitary certificate"),
   /**
    * Document or message issued by the competent authority in
    * the exporting country evidencing that inedible products
    * comply with the requirements set by the importing
    * country.
    */
   _95("Inedible sanitary certificate"),
   /**
    * Notification of impending arrival details for vessel.
    */
   _96("Impending arrival"),
   /**
    * Message reporting the means of transport used to carry
    * goods or cargo.
    */
   _97("Means of transport advice"),
   /**
    * Message reporting the arrival details of goods or cargo.
    */
   _98("Arrival information"),
   /**
    * Message/document sent by the cargo handler indicating
    * that the cargo has moved from a Customs controlled
    * premise.
    */
   _99("Cargo release notification"),
   /**
    * Certificate asserting that the goods have been submitted
    * to the excise authorities before departure from the
    * exporting country or before delivery in case of import
    * traffic.
    */
   _100("Excise certificate"),
   /**
    * An official document providing registration details.
    */
   _101("Registration document"),
   /**
    * Used to specify that the message is a tax notification.
    */
   _102("Tax notification"),
   /**
    * Report on the movement of containers or other items of
    * transport equipment being exchanged, establishing
    * relevant rental periods.
    */
   _103("Transport equipment direct interchange report"),
   /**
    * Advice that containers or other items of transport
    * equipment may be expected to be delivered to a certain
    * location.
    */
   _104("Transport equipment impending arrival advice"),
   /**
    * Document/message issued within an enterprise to initiate
    * the purchase of articles, materials or services required
    * for the production or manufacture of goods to be offered
    * for sale or otherwise supplied to customers.
    */
   _105("Purchase order"),
   /**
    * Report of damaged items of transport equipment that have
    * been returned.
    */
   _106("Transport equipment damage report"),
   /**
    * advice
    * Advice providing estimates of transport equipment
    * maintenance and repair costs.
    */
   _107("Transport equipment maintenance and repair work estimate"),
   /**
    * Instruction to release an item of empty transport
    * equipment to a specified party or parties.
    */
   _108("Transport equipment empty release instruction"),
   /**
    * Report on the inward movement of cargo, containers or
    * other items of transport equipment which have been
    * delivered to a facility by an inland carrier.
    */
   _109("Transport movement gate in report"),
   /**
    * Document/message issued within an enterprise to initiate
    * the manufacture of goods to be offered for sale.
    */
   _110("Manufacturing instructions"),
   /**
    * Report on the outward movement of cargo, containers or
    * other items of transport equipment (either full or
    * empty) which have been picked up by an inland carrier.
    */
   _111("Transport movement gate out report"),
   /**
    * Instruction to unpack specified cargo from specified
    * containers or other items of transport equipment.
    */
   _112("Transport equipment unpacking instruction"),
   /**
    * Report on the completion of unpacking specified
    * containers or other items of transport equipment.
    */
   _113("Transport equipment unpacking report"),
   /**
    * Request for confirmation that an item of transport
    * equipment will be available for collection.
    */
   _114("Transport equipment pick-up availability request"),
   /**
    * Confirmation that an item of transport equipment is
    * available for collection.
    */
   _115("Transport equipment pick-up availability confirmation"),
   /**
    * Report that an item of transport equipment has been
    * collected.
    */
   _116("Transport equipment pick-up report"),
   /**
    * Report on the movement of containers or other items of
    * transport within a facility.
    */
   _117("Transport equipment shift report"),
   /**
    * Instruction to unload specified cargo, containers or
    * transport equipment from a means of transport.
    */
   _118("Transport discharge instruction"),
   /**
    * Report on cargo, containers or transport equipment
    * unloaded from a particular means of transport.
    */
   _119("Transport discharge report"),
   /**
    * Document/message issued within an enterprise ordering
    * the taking out of stock of goods.
    */
   _120("Stores requisition"),
   /**
    * Instruction to load cargo, containers or transport
    * equipment onto a means of transport.
    */
   _121("Transport loading instruction"),
   /**
    * Report on completion of loading cargo, containers or
    * other transport equipment onto a means of transport.
    */
   _122("Transport loading report"),
   /**
    * authorisation
    * Authorisation to have transport equipment repaired or to
    * have maintenance performed.
    */
   _123("Transport equipment maintenance and repair work"),
   /**
    * Report of the departure of a means of transport from a
    * particular facility.
    */
   _124("Transport departure report"),
   /**
    * Advice that an item or items of empty transport
    * equipment are available for return.
    */
   _125("Transport empty equipment advice"),
   /**
    * Order to accept items of transport equipment which are
    * to be delivered by an inland carrier (rail, road or
    * barge) to a specified facility.
    */
   _126("Transport equipment acceptance order"),
   /**
    * Instruction to perform a specified service or services
    * on an item or items of transport equipment.
    */
   _127("Transport equipment special service instruction"),
   /**
    * Report on the number of items of transport equipment
    * stored at one or more locations.
    */
   _128("Transport equipment stock report"),
   /**
    * Order to release cargo or items of transport equipment
    * to a specified party.
    */
   _129("Transport cargo release order"),
   /**
    * Document/message issued within an enterprise containing
    * data about goods sold, to be used as the basis for the
    * preparation of an invoice.
    */
   _130("Invoicing data sheet"),
   /**
    * Instruction to pack cargo into a container or other item
    * of transport equipment.
    */
   _131("Transport equipment packing instruction"),
   /**
    * Notification of customs clearance of cargo or items of
    * transport equipment.
    */
   _132("Customs clearance notice"),
   /**
    * Notice specifying expiration of Customs documents
    * relating to cargo or items of transport equipment.
    */
   _133("Customs documents expiration notice"),
   /**
    * Request for transport equipment to be made available for
    * hire.
    */
   _134("Transport equipment on-hire request"),
   /**
    * Order to release empty items of transport equipment for
    * on-hire to a lessee, and authorising collection by or on
    * behalf of a specified party.
    */
   _135("Transport equipment on-hire order"),
   /**
    * Request to terminate the lease on an item of transport
    * equipment at a specified time.
    */
   _136("Transport equipment off-hire request"),
   /**
    * Order to perform a survey on specified items of
    * transport equipment.
    */
   _137("Transport equipment survey order"),
   /**
    * Response to an order to conduct a survey of transport
    * equipment.
    */
   _138("Transport equipment survey order response"),
   /**
    * Survey report of specified items of transport equipment.
    */
   _139("Transport equipment survey report"),
   /**
    * Document/message within an enterprise giving
    * instructions on how goods are to be packed.
    */
   _140("Packing instructions"),
   /**
    * A document and/or message advising of items which have
    * to be booked to a financial account.
    */
   _141("Advising items to be booked to a financial account"),
   /**
    * order
    * Order to draw up an estimate of the costs of maintenance
    * or repair of transport equipment.
    */
   _142("Transport equipment maintenance and repair work estimate"),
   /**
    * Report of transport equipment which has been repaired or
    * has had maintenance performed.
    */
   _143("Transport equipment maintenance and repair notice"),
   /**
    * Order to make available empty containers.
    */
   _144("Empty container disposition order"),
   /**
    * Order that the containers or cargo specified are to be
    * discharged from a vessel.
    */
   _145("Cargo vessel discharge order"),
   /**
    * Order that specified cargo, containers or groups of
    * containers are to be loaded in or on a vessel.
    */
   _146("Cargo vessel loading order"),
   /**
    * One purchase order that contains the orders of two or
    * more vendors and the associated delivery points for
    * each.
    */
   _147("Multidrop order"),
   /**
    * A document authorizing the bailing of goods.
    */
   _148("Bailment contract"),
   /**
    * A document indicating an agreement containing basic
    * terms and conditions applicable to future contracts
    * between two parties.
    */
   _149("Basic agreement"),
   /**
    * Document/message giving instructions about the transport
    * of goods within an enterprise.
    */
   _150("Internal transport order"),
   /**
    * A document indicating the granting of funds.
    */
   _151("Grant"),
   /**
    * A document indicating a contract calling for the
    * indefinite deliveries of indefinite quantities of goods.
    */
   _152("Indefinite delivery indefinite quantity contract"),
   /**
    * A document indicating a contract calling for indefinite
    * deliveries of definite quantities.
    */
   _153("Indefinite delivery definite quantity contract"),
   /**
    * A document indicating a requirements contract that
    * authorizes the filling of all purchase requirements
    * during a specified contract period.
    */
   _154("Requirements contract"),
   /**
    * A document indicating an order that tasks a contractor
    * to perform a specified function.
    */
   _155("Task order"),
   /**
    * A document indicating a plan that identifies which items
    * will be made and which items will be bought.
    */
   _156("Make or buy plan"),
   /**
    * A document indicating a plan that identifies the
    * manufacturer's subcontracting strategy for a specific
    * contract.
    */
   _157("Subcontractor plan"),
   /**
    * A document indicating a summary of cost data.
    */
   _158("Cost data summary"),
   /**
    * A document indicating cost and price data whose accuracy
    * has been certified.
    */
   _159("Certified cost and price data"),
   /**
    * A document indicating a determination of the wages to be
    * paid.
    */
   _160("Wage determination"),
   /**
    * A report to provide the status of funds applicable to
    * the contract.
    */
   _161("Contract Funds Status Report (CFSR)"),
   /**
    * A certification as to the accuracy of inspection and
    * test results.
    */
   _162("Certified inspection and test results"),
   /**
    * A report that is both an inspection report for materials
    * and a receiving document.
    */
   _163("Material inspection and receiving report"),
   /**
    * A document indicating a specification used to purchase
    * an item.
    */
   _164("Purchasing specification"),
   /**
    * A document indicating a bond that guarantees the payment
    * of monies or a performance.
    */
   _165("Payment or performance bond"),
   /**
    * A document that indicates the specification contains the
    * security and classification requirements for a contract.
    */
   _166("Contract security classification specification"),
   /**
    * A document indicating the specification of how an item
    * is to be manufactured.
    */
   _167("Manufacturing specification"),
   /**
    * A document certifying that more than 50 percent of the
    * cost of an item is attributed to US origin.
    */
   _168("Buy America certificate of compliance"),
   /**
    * Notice to return leased containers.
    */
   _169("Container off-hire notice"),
   /**
    * Order to accept cargo to be delivered by a carrier.
    */
   _170("Cargo acceptance order"),
   /**
    * Notice specifying the pick-up of released cargo or
    * containers from a certain address.
    */
   _171("Pick-up notice"),
   /**
    * Document or message that authorises receiver to plan
    * orders, based on information in this message, and send
    * these orders as suggestions to the sender.
    */
   _172("Authorisation to plan and suggest orders"),
   /**
    * Document or message that authorises receiver to plan and
    * ship orders based on information in this message.
    */
   _173("Authorisation to plan and ship orders"),
   /**
    * The document or message is a drawing.
    */
   _174("Drawing"),
   /**
    * A report identifying the cost performance on a contract
    * at specified levels of the work breakdown structure
    * (format 2 - organizational categories).
    */
   _175("Cost Performance Report (CPR) format 2"),
   /**
    * A report providing the status of the cost and schedule
    * applicable to a contract.
    */
   _176("Cost Schedule Status Report (CSSR)"),
   /**
    * A report identifying the cost performance on a contract
    * including the current month's values at specified levels
    * of the work breakdown structure (format 1 - work
    * breakdown structure).
    */
   _177("Cost Performance Report (CPR) format 1"),
   /**
    * A report identifying the cost performance on a contract
    * that summarizes changes to a contract over a given
    * reporting period with beginning and ending values
    * (format 3 - baseline).
    */
   _178("Cost Performance Report (CPR) format 3"),
   /**
    * A report identifying the cost performance on a contract
    * including forecasts of labour requirements for the
    * remaining portion of the contract (format 4 - staffing).
    */
   _179("Cost Performance Report (CPR) format 4"),
   /**
    * A report identifying the cost performance on a contract
    * that summarizes cost or schedule variances (format 5 -
    * explanations and problem analysis).
    */
   _180("Cost Performance Report (CPR) format 5"),
   /**
    * Document or message progressively issued by the
    * container terminal operator in charge of discharging a
    * vessel identifying containers that have been discharged
    * from a specific vessel at that point in time.
    */
   _181("Progressive discharge report"),
   /**
    * Confirmation of a balance at an entry date.
    */
   _182("Balance confirmation"),
   /**
    * Order to unload goods from a container.
    */
   _183("Container stripping order"),
   /**
    * Order to stuff specified goods or consignments in a
    * container.
    */
   _184("Container stuffing order"),
   /**
    * Declaration to the public authority upon arrival of the
    * conveyance.
    */
   _185("Conveyance declaration (arrival)"),
   /**
    * Declaration to the public authority upon departure of
    * the conveyance.
    */
   _186("Conveyance declaration (departure)"),
   /**
    * Combined declaration of arrival and departure to the
    * public authority.
    */
   _187("Conveyance declaration (combined)"),
   /**
    * A project plan for recovery after a delay or problem
    * resolution.
    */
   _188("Project recovery plan"),
   /**
    * A project plan for the production of goods.
    */
   _189("Project production plan"),
   /**
    * Documents/messages issued within an enterprise for the
    * for the purpose of collection of production and other
    * internal statistics, and for other administration
    * purposes.
    */
   _190("Statistical and other administrative internal documents"),
   /**
    * A high level, all encompassing master schedule of
    * activities to complete a project.
    */
   _191("Project master schedule"),
   /**
    * A priced tender based upon an alternate specification.
    */
   _192("Priced alternate tender bill of quantity"),
   /**
    * An estimate based upon a detailed, quantity based
    * specification (bill of quantity).
    */
   _193("Estimated priced bill of quantity"),
   /**
    * Document/message providing a draft bill of quantity,
    * issued in an unpriced form.
    */
   _194("Draft bill of quantity"),
   /**
    * Instruction for the collection of the documentary
    * credit.
    */
   _195("Documentary credit collection instruction"),
   /**
    * Request for an amendment of a documentary credit.
    */
   _196("Request for an amendment of a documentary credit"),
   /**
    * Documentary credit amendment information.
    */
   _197("Documentary credit amendment information"),
   /**
    * Advice of an amendment of a documentary credit.
    */
   _198("Advice of an amendment of a documentary credit"),
   /**
    * Response to an amendment of a documentary credit.
    */
   _199("Response to an amendment of a documentary credit"),
   /**
    * Provides information on documentary credit issuance.
    */
   _200("Documentary credit issuance information"),
   /**
    * Request to establish a direct payment valuation.
    */
   _201("Direct payment valuation request"),
   /**
    * Document/message addressed, for instance, by a general
    * contractor to the owner, in order that a direct payment
    * be made to a subcontractor.
    */
   _202("Direct payment valuation"),
   /**
    * Document/message establishing a provisional payment
    * valuation.
    */
   _203("Provisional payment valuation"),
   /**
    * Document/message establishing the financial elements of
    * a situation of works.
    */
   _204("Payment valuation"),
   /**
    * Document/message providing a confirmed assessment, by
    * quantity, of the completed work for a construction
    * contract.
    */
   _205("Quantity valuation"),
   /**
    * Document/message providing an initial assessment, by
    * quantity, of the completed work for a construction
    * contract.
    */
   _206("Quantity valuation request"),
   /**
    * Document/message providing a formal specification
    * identifying quantities and prices that are the basis of
    * a contract for a construction project. BOQ means: Bill
    * of quantity.
    */
   _207("Contract bill of quantities - BOQ"),
   /**
    * Document/message providing a detailed, quantity based
    * specification, issued in an unpriced form to invite
    * tender prices.
    */
   _208("Unpriced bill of quantity"),
   /**
    * Document/message providing a detailed, quantity based
    * specification, updated with prices to form a tender
    * submission for a construction contract. BOQ means: Bill
    * of quantity.
    */
   _209("Priced tender BOQ"),
   /**
    * Document/message issued by a party interested in the
    * purchase of goods specified therein and indicating
    * particular, desirable conditions regarding delivery
    * terms, etc., addressed to a prospective supplier with a
    * view to obtaining an offer.
    */
   _210("Enquiry"),
   /**
    * Document/message containing a provisional assessment in
    * support of a request for payment for completed work for
    * a construction contract.
    */
   _211("Interim application for payment"),
   /**
    * Document/message in which the debtor expresses the
    * intention to pay.
    */
   _212("Agreement to pay"),
   /**
    * The message is a request for financial cancellation.
    */
   _213("Request for financial cancellation"),
   /**
    * The message contains pre-authorised direct debit(s).
    */
   _214("Pre-authorised direct debit(s)"),
   /**
    * Document/message by means of which a buyer informs a
    * seller that the buyer intends to enter into contractual
    * negotiations.
    */
   _215("Letter of intent"),
   /**
    * Document/message providing an approved detailed,
    * quantity based specification (bill of quantity), in an
    * unpriced form.
    */
   _216("Approved unpriced bill of quantity"),
   /**
    * A payment valuation for unscheduled items.
    */
   _217("Payment valuation for unscheduled items"),
   /**
    * The final payment request of a series of payment
    * requests submitted upon completion of all the work.
    */
   _218("Final payment request based on completion of work"),
   /**
    * A request for payment for completed units.
    */
   _219("Payment request for completed units"),
   /**
    * Document/message by means of which a buyer initiates a
    * transaction with a seller involving the supply of goods
    * or services as specified, according to conditions set
    * out in an offer, or otherwise known to the buyer.
    */
   _220("Order"),
   /**
    * Usage of document/message for general order purposes
    * with later split into quantities and delivery dates and
    * maybe delivery locations.
    */
   _221("Blanket order"),
   /**
    * Document/message ordering the remainder of a
    * production's batch.
    */
   _222("Spot order"),
   /**
    * Document/message for goods in leasing contracts.
    */
   _223("Lease order"),
   /**
    * Document/message for urgent ordering.
    */
   _224("Rush order"),
   /**
    * Document/message to order repair of goods.
    */
   _225("Repair order"),
   /**
    * Document/message to provide split quantities and
    * delivery dates referring to a previous blanket order.
    */
   _226("Call off order"),
   /**
    * Order to deliver goods into stock with agreement on
    * payment when goods are sold out of this stock.
    */
   _227("Consignment order"),
   /**
    * Document/message to order samples.
    */
   _228("Sample order"),
   /**
    * Document/message informing buyer or seller of the
    * replacement of goods previously ordered.
    */
   _229("Swap order"),
   /**
    * Change to an purchase order already sent.
    */
   _230("Purchase order change request"),
   /**
    * Response to an purchase order already received.
    */
   _231("Purchase order response"),
   /**
    * Document/message for hiring human resources or renting
    * goods or equipment.
    */
   _232("Hire order"),
   /**
    * Document/message to order spare parts.
    */
   _233("Spare parts order"),
   /**
    * A price/sales catalogue containing special prices which
    * are valid only for a specified period or under specified
    * conditions.
    */
   _234("Campaign price/sales catalogue"),
   /**
    * Document or message issued by party identifying the
    * containers for which they are responsible.
    */
   _235("Container list"),
   /**
    * A message which enables the transmission of delivery or
    * product forecasting requirements.
    */
   _236("Delivery forecast"),
   /**
    * A document or message to order cross docking services.
    */
   _237("Cross docking services order"),
   /**
    * The message contains non-pre-authorised direct debit(s).
    */
   _238("Non-pre-authorised direct debit(s)"),
   /**
    * The message contains rejected direct debit(s).
    */
   _239("Rejected direct debit(s)"),
   /**
    * (1174) Document/message giving instruction regarding the
    * delivery of goods.
    */
   _240("Delivery instructions"),
   /**
    * Usage of DELFOR-message.
    */
   _241("Delivery schedule"),
   /**
    * Usage of DELJIT-message.
    */
   _242("Delivery just-in-time"),
   /**
    * The message contains pre-authorised direct debit
    * request(s).
    */
   _243("Pre-authorised direct debit request(s)"),
   /**
    * The message contains non-pre-authorised direct debit
    * request(s).
    */
   _244("Non-pre-authorised direct debit request(s)"),
   /**
    * Document/message issued by a buyer releasing the
    * despatch of goods after receipt of the Ready for
    * despatch advice from the seller.
    */
   _245("Delivery release"),
   /**
    * Settlement of a letter of credit.
    */
   _246("Settlement of a letter of credit"),
   /**
    * The message is a bank to bank funds transfer.
    */
   _247("Bank to bank funds transfer"),
   /**
    * The message contains customer payment order(s).
    */
   _248("Customer payment order(s)"),
   /**
    * The message contains low value payment order(s) only.
    */
   _249("Low value payment order(s)"),
   /**
    * Declaration regarding crew members aboard the
    * conveyance.
    */
   _250("Crew list declaration"),
   /**
    * This is a request for information.
    */
   _251("Inquiry"),
   /**
    * A response to a previously sent banking status message.
    */
   _252("Response to previous banking status message"),
   /**
    * A high level, all encompassing master plan to complete a
    * project.
    */
   _253("Project master plan"),
   /**
    * A plan for project work to be completed.
    */
   _254("Project plan"),
   /**
    * A schedule of project activities to be completed.
    */
   _255("Project schedule"),
   /**
    * Available resources for project planning purposes.
    */
   _256("Project planning available resources"),
   /**
    * Work calendar information for project planning purposes.
    */
   _257("Project planning calendar"),
   /**
    * An order to supply fixed quantities of products at fixed
    * regular intervals.
    */
   _258("Standing order"),
   /**
    * A document detailing times and dates of events
    * pertaining to a cargo movement.
    */
   _259("Cargo movement event log"),
   /**
    * An analysis of the cargo for a voyage.
    */
   _260("Cargo analysis voyage report"),
   /**
    * A document which indicates that the customer is claiming
    * credit in a self billing environment.
    */
   _261("Self billed credit note"),
   /**
    * Credit note for goods and services that covers multiple
    * transactions involving more than one invoice.
    */
   _262("Consolidated credit note - goods and services"),
   /**
    * A message detailing statuses related to the adjustment
    * of inventory.
    */
   _263("Inventory adjustment status report"),
   /**
    * Instruction to perform one or more different movements
    * of transport equipment.
    */
   _264("Transport equipment movement instruction"),
   /**
    * Report on one or more different movements of transport
    * equipment.
    */
   _265("Transport equipment movement report"),
   /**
    * Report on one or more changes of status associated with
    * an item or items of transport equipment.
    */
   _266("Transport equipment status change report"),
   /**
    * Certificate attesting that fumigation has been
    * performed.
    */
   _267("Fumigation certificate"),
   /**
    * Certificate attesting to the quality, origin or
    * appellation of wine.
    */
   _268("Wine certificate"),
   /**
    * Certificate attesting that wool is free from specified
    * risks to human or animal health.
    */
   _269("Wool health certificate"),
   /**
    * Paper document attached to a consignment informing the
    * receiving party about contents of this consignment.
    */
   _270("Delivery note"),
   /**
    * Document/message specifying the distribution of goods in
    * individual packages (in trade environment the despatch
    * advice message is used for the packing list).
    */
   _271("Packing list"),
   /**
    * Requesting a new code.
    */
   _272("New code request"),
   /**
    * Request a change to an existing code.
    */
   _273("Code change request"),
   /**
    * Requesting a new simple data element.
    */
   _274("Simple data element request"),
   /**
    * Request a change to an existing simple data element.
    */
   _275("Simple data element change request"),
   /**
    * Requesting a new composite data element.
    */
   _276("Composite data element request"),
   /**
    * Request a change to an existing composite data element.
    */
   _277("Composite data element change request"),
   /**
    * Request a new segment.
    */
   _278("Segment request"),
   /**
    * Requesting a change to an existing segment.
    */
   _279("Segment change request"),
   /**
    * Request for a new message (NMR).
    */
   _280("New message request"),
   /**
    * Requesting a Message in Development (MiD).
    */
   _281("Message in development request"),
   /**
    * Requesting a change to an existing message.
    */
   _282("Modification of existing message"),
   /**
    * Report of assigned tracking numbers.
    */
   _283("Tracking number assignment report"),
   /**
    * Document/message defining the contents of a user
    * directory set or parts thereof.
    */
   _284("User directory definition"),
   /**
    * Requesting a United Nations Standard Message (UNSM).
    */
   _285("United Nations standard message request"),
   /**
    * Document/message defining the contents of a service
    * directory set or parts thereof.
    */
   _286("Service directory definition"),
   /**
    * Message covers information about the status.
    */
   _287("Status report"),
   /**
    * Message to describe a Kanban schedule.
    */
   _288("Kanban schedule"),
   /**
    * A message to submit master data, a set of data that is
    * rarely changed, to identify and describe products a
    * supplier offers to their (potential) customer or buyer.
    */
   _289("Product data message"),
   /**
    * A claim for parts and/or labour charges incurred .
    */
   _290("A claim for parts and/or labour charges"),
   /**
    * A message providing a response to a previously
    * transmitted delivery schedule.
    */
   _291("Delivery schedule response"),
   /**
    * A message requesting a party to inspect items.
    */
   _292("Inspection request"),
   /**
    * A message informing a party of the results of an
    * inspection.
    */
   _293("Inspection report"),
   /**
    * A message used by an application to acknowledge
    * reception of a message and/or to report any errors.
    */
   _294("Application acknowledgement and error report"),
   /**
    * An invoice which requests payment for the difference in
    * price between an original invoice and the result of the
    * application of a price variation formula.
    */
   _295("Price variation invoice"),
   /**
    * A credit note which is issued against a price variation
    * invoice.
    */
   _296("Credit note for price variation"),
   /**
    * A message instructing a party to collect goods.
    */
   _297("Instruction to collect"),
   /**
    * Listing of all details of dangerous goods carried.
    */
   _298("Dangerous goods list"),
   /**
    * Code specifying the continued validity of previously
    * submitted registration information.
    */
   _299("Registration renewal"),
   /**
    * Code specifying the modification of previously submitted
    * registration information.
    */
   _300("Registration change"),
   /**
    * Code specifying a response to an occurrence of a
    * registration message.
    */
   _301("Response to registration"),
   /**
    * A document specifying the criterion and format for
    * exchanging information in an electronic data interchange
    * syntax.
    */
   _302("Implementation guideline"),
   /**
    * Document/message is a request for transfer.
    */
   _303("Request for transfer"),
   /**
    * A report to convey cost performance data for a project
    * or contract.
    */
   _304("Cost performance report"),
   /**
    * A message to inform a message issuer that a previously
    * sent message has been received by the addressee's
    * application, or that a previously sent message has been
    * rejected by the addressee's application.
    */
   _305("Application error and acknowledgement"),
   /**
    * A financial statement for a cash pool.
    */
   _306("Cash pool financial statement"),
   /**
    * Message to describe a sequence of product delivery.
    */
   _307("Sequenced delivery schedule"),
   /**
    * A credit note sent to the party paying on behalf of a
    * number of buyers.
    */
   _308("Delcredere credit note"),
   /**
    * Final discharge report by healthcare provider.
    */
   _309("Healthcare discharge report, final"),
   /**
    * (1332) Document/message which, with a view to concluding
    * a contract, sets out the conditions under which the
    * goods are offered.
    */
   _310("Offer / quotation"),
   /**
    * Document/message requesting a quote on specified goods
    * or services.
    */
   _311("Request for quote"),
   /**
    * Message providing acknowledgement information at the
    * business application level concerning the processing of
    * a message.
    */
   _312("Acknowledgement message"),
   /**
    * Message indicating that a message was rejected due to
    * errors encountered at the application level.
    */
   _313("Application error message"),
   /**
    * A consolidated voyage summary which contains the
    * information in a certificate of analysis, a voyage
    * analysis and a cargo movement time log for a voyage.
    */
   _314("Cargo movement voyage summary"),
   /**
    * (1296) Document/message evidencing an agreement between
    * the seller and the buyer for the supply of goods or
    * services; its effects are equivalent to those of an
    * order followed by an acknowledgement of order.
    */
   _315("Contract"),
   /**
    * Document to apply for usage of berth or mooring
    * facilities.
    */
   _316("Application for usage of berth or mooring facilities"),
   /**
    * Document to apply for designation of berthing places.
    */
   _317("Application for designation of berthing places"),
   /**
    * Document to apply for shifting from the designated place
    * in port.
    */
   _318("Application for shifting from the designated place in port"),
   /**
    * of dangerous goods
    * Supplementary document to apply for cargo operation of
    * dangerous goods.
    */
   _319("Supplementary document for application for cargo operation"),
   /**
    * Document/message acknowledging an undertaking to fulfil
    * an order and confirming conditions or acceptance of
    * conditions.
    */
   _320("Acknowledgement of order"),
   /**
    * dangerous goods
    * Supplementary document to apply for transport of
    * dangerous goods.
    */
   _321("Supplementary document for application for transport of"),
   /**
    * Payment effected by an Optical Character Reading (OCR)
    * document.
    */
   _322("Optical Character Reading (OCR) payment"),
   /**
    * Preliminary sales report sent before all the information
    * is available.
    */
   _323("Preliminary sales report"),
   /**
    * Official document specifying, for a given dangerous
    * goods item, information such as nature of hazard,
    * protective devices, actions to be taken in case of
    * accident, spillage or fire and first aid to be given.
    */
   _324("Transport emergency card"),
   /**
    * Document/message serving as a preliminary invoice,
    * containing - on the whole - the same information as the
    * final invoice, but not actually claiming payment.
    */
   _325("Proforma invoice"),
   /**
    * Document/message specifying details of an incomplete
    * invoice.
    */
   _326("Partial invoice"),
   /**
    * Document/message describing instructions for operation.
    */
   _327("Operating instructions"),
   /**
    * Plates on goods identifying and describing an article.
    */
   _328("Name/product plate"),
   /**
    * The document or message contains a bordereau describing
    * co-insurance ceding information.
    */
   _329("Co-insurance ceding bordereau"),
   /**
    * Document/message issued by a supplier requesting
    * instructions from the buyer regarding the details of the
    * delivery of goods ordered.
    */
   _330("Request for delivery instructions"),
   /**
    * Commercial transaction (invoice) will include a packing
    * list.
    */
   _331("Commercial invoice which includes a packing list"),
   /**
    * Document/message is for trade data.
    */
   _332("Trade data"),
   /**
    * Declaration provided to customs for cargo examination.
    */
   _333("Customs declaration for cargo examination"),
   /**
    * Alternate declaration provided to customs for cargo
    * examination.
    */
   _334("Customs declaration for cargo examination, alternate"),
   /**
    * Document/message issued by a supplier to a carrier
    * requesting space to be reserved for a specified
    * consignment, indicating desirable conveyance, despatch
    * time, etc.
    */
   _335("Booking request"),
   /**
    * Document/message contains information regarding the crew
    * list and conveyance.
    */
   _336("Customs crew and conveyance"),
   /**
    * alternate
    * Alternate Customs declaration summary with commercial
    * transaction details.
    */
   _337("Customs summary declaration with commercial detail,"),
   /**
    * A message reporting items which have been booked to a
    * financial account.
    */
   _338("Items booked to a financial account report"),
   /**
    * the receiver
    * A message reporting transactions which need further
    * information from the receiver.
    */
   _339("Report of transactions which need further information from"),
   /**
    * (1121) Document/message advising details of cargo and
    * exporter's requirements for its physical movement.
    */
   _340("Shipping instructions"),
   /**
    * Document/message issued by a consignor in which he gives
    * details of a consignment of goods that enables an
    * airline or its agent to prepare an air waybill.
    */
   _341("Shipper's letter of instructions (air)"),
   /**
    * A message reporting transactions for information only.
    */
   _342("Report of transactions for information only"),
   /**
    * Document/message giving instructions regarding local
    * transport of goods, e.g. from the premises of an
    * enterprise to those of a carrier undertaking further
    * transport.
    */
   _343("Cartage order (local transport)"),
   /**
    * A message giving additional information about the
    * exchange of an EDI associated object.
    */
   _344("EDI associated object administration message"),
   /**
    * Document/message issued by a supplier informing a buyer
    * that goods ordered are ready for despatch.
    */
   _345("Ready for despatch advice"),
   /**
    * Sales report containing summaries for several earlier
    * sent sales reports.
    */
   _346("Summary sales report"),
   /**
    * A message enquiring the status of previously sent
    * orders.
    */
   _347("Order status enquiry"),
   /**
    * A message reporting the status of previously sent
    * orders.
    */
   _348("Order status report"),
   /**
    * vessel
    * Document to declare inward and outward movement of a
    * vessel.
    */
   _349("Declaration regarding the inward and outward movement of"),
   /**
    * Document/message issued by a supplier initiating the
    * despatch of goods to a buyer (consignee).
    */
   _350("Despatch order"),
   /**
    * Document/message by means of which the seller or
    * consignor informs the consignee about the despatch of
    * goods.
    */
   _351("Despatch advice"),
   /**
    * Document to notify usage of berth or mooring facilities.
    */
   _352("Notification of usage of berth or mooring facilities"),
   /**
    * time
    * Document to apply for vessel's entering into port area
    * in night-time.
    */
   _353("Application for vessel's entering into port area in night-"),
   /**
    * place in port
    * Document to notify shifting from designated place in
    * port once secured at the designated place.
    */
   _354("Notification of emergency shifting from the designated"),
   /**
    * alternate
    * Alternate Customs declaration summary without any
    * commercial transaction details.
    */
   _355("Customs summary declaration without commercial detail,"),
   /**
    * A document that guarantees performance.
    */
   _356("Performance bond"),
   /**
    * A document that guarantees the payment of monies.
    */
   _357("Payment bond"),
   /**
    * Preliminary discharge report by healthcare provider.
    */
   _358("Healthcare discharge report, preliminary"),
   /**
    * Document containing request for provision of a health
    * service.
    */
   _359("Request for provision of a health service"),
   /**
    * Document/message requesting price conditions under which
    * goods are offered.
    */
   _360("Request for price quote"),
   /**
    * Document/message confirming price conditions under which
    * goods are offered.
    */
   _361("Price quote"),
   /**
    * Document/message confirming delivery conditions under
    * which goods are offered.
    */
   _362("Delivery quote"),
   /**
    * Document/message confirming price and delivery
    * conditions under which goods are offered.
    */
   _363("Price and delivery quote"),
   /**
    * Document/message confirming contractual price conditions
    * under which goods are offered.
    */
   _364("Contract price quote"),
   /**
    * Document/message confirming contractual price conditions
    * and contractual delivery conditions under which goods
    * are offered.
    */
   _365("Contract price and delivery quote"),
   /**
    * Document/message confirming price conditions under which
    * goods are offered, provided that they are sold to the
    * end-customer specified on the quote.
    */
   _366("Price quote, specified end-customer"),
   /**
    * Document/message confirming price conditions and
    * delivery conditions under which goods are offered,
    * provided that they are sold to the end-customer
    * specified on the quote.
    */
   _367("Price and delivery quote, specified end-customer"),
   /**
    * Document/message from a supplier to a distributor
    * confirming price conditions under which goods can be
    * sold by a distributor to the end-customer specified on
    * the quote with compensation for loss of inventory value.
    */
   _368("Price quote, ship and debit"),
   /**
    * Document/message from a supplier to a distributor
    * confirming price conditions and delivery conditions
    * under which goods can be sold by a distributor to the
    * end-customer specified on the quote with compensation
    * for loss of inventory value.
    */
   _369("Price and delivery quote, ship and debit"),
   /**
    * Document/message in which the party responsible for the
    * issue of a set of trade documents specifies the various
    * recipients of originals and copies of these documents,
    * with an indication of the number of copies distributed
    * to each of them.
    */
   _370("Advice of distribution of documents"),
   /**
    * Document containing a plan for provision of health
    * service.
    */
   _371("Plan for provision of health service"),
   /**
    * Instructions for the dispensing and use of medicine or
    * remedy.
    */
   _372("Prescription"),
   /**
    * Request to issue a prescription for medicine or remedy.
    */
   _373("Prescription request"),
   /**
    * Document containing information of products dispensed
    * according to a prescription.
    */
   _374("Prescription dispensing report"),
   /**
    * (1109) Certificate providing confirmation that a
    * consignment has been shipped.
    */
   _375("Certificate of shipment"),
   /**
    * A product inquiry which stands until it is cancelled.
    */
   _376("Standing inquiry on product information"),
   /**
    * Document/message providing data concerning the credit
    * information of a party.
    */
   _377("Party credit information"),
   /**
    * Document/message providing data concerning the payment
    * behaviour of a party.
    */
   _378("Party payment behaviour information"),
   /**
    * Message to request information about a metering point.
    */
   _379("Request for metering point information"),
   /**
    * (1334) Document/message claiming payment for goods or
    * services supplied under conditions agreed between seller
    * and buyer.
    */
   _380("Commercial invoice"),
   /**
    * (1113) Document/message for providing credit information
    * to the relevant party.
    */
   _381("Credit note"),
   /**
    * (1111) Document/message in which a seller specifies the
    * amount of commission, the percentage of the invoice
    * amount, or some other basis for the calculation of the
    * commission to which a sales agent is entitled.
    */
   _382("Commission note"),
   /**
    * Document/message for providing debit information to the
    * relevant party.
    */
   _383("Debit note"),
   /**
    * Commercial invoice that includes revised information
    * differing from an earlier submission of the same
    * invoice.
    */
   _384("Corrected invoice"),
   /**
    * Commercial invoice that covers multiple transactions
    * involving more than one vendor.
    */
   _385("Consolidated invoice"),
   /**
    * An invoice to pay amounts for goods and services in
    * advance; these amounts will be subtracted from the final
    * invoice.
    */
   _386("Prepayment invoice"),
   /**
    * Document/message for invoicing the hiring of human
    * resources or renting goods or equipment.
    */
   _387("Hire invoice"),
   /**
    * An invoice for tax purposes.
    */
   _388("Tax invoice"),
   /**
    * An invoice the invoicee is producing instead of the
    * seller.
    */
   _389("Self-billed invoice"),
   /**
    * An invoice sent to the party paying for a number of
    * buyers.
    */
   _390("Delcredere invoice"),
   /**
    * Response to a request for information about a metering
    * point.
    */
   _391("Metering point information response"),
   /**
    * A notification of a change of supplier.
    */
   _392("Notification of change of supplier"),
   /**
    * Invoice assigned to a third party for collection.
    */
   _393("Factored invoice"),
   /**
    * Usage of INVOIC-message for goods in leasing contracts.
    */
   _394("Lease invoice"),
   /**
    * Commercial invoice that covers a transaction other than
    * one involving a sale.
    */
   _395("Consignment invoice"),
   /**
    * Credit note related to assigned invoice(s).
    */
   _396("Factored credit note"),
   /**
    * A document providing a response to a previously sent
    * commercial account summary message.
    */
   _397("Commercial account summary response"),
   /**
    * Document by means of which the supplier or consignor
    * informs the buyer, consignee or the distribution centre
    * about the despatch of goods for cross docking.
    */
   _398("Cross docking despatch advice"),
   /**
    * Document by means of which the supplier or consignor
    * informs the buyer, consignee or the distribution centre
    * about the despatch of goods for transshipment.
    */
   _399("Transshipment despatch advice"),
   /**
    * An order which falls outside the framework of an
    * agreement.
    */
   _400("Exceptional order"),
   /**
    * An order requesting the supply of products packed
    * according to the final delivery point which will be
    * moved across a dock in a distribution centre without
    * further handling.
    */
   _401("Pre-packed cross docking order"),
   /**
    * An order requesting the supply of products which will be
    * moved across a dock, de-consolidated and re-consolidated
    * according to the final delivery location requirements.
    */
   _402("Intermediate handling cross docking order"),
   /**
    * Information giving the various availabilities of a means
    * of transportation.
    */
   _403("Means of transportation availability information"),
   /**
    * Information giving the various schedules of a means of
    * transportation.
    */
   _404("Means of transportation schedule information"),
   /**
    * Notification regarding the delivery of transport
    * equipment.
    */
   _405("Transport equipment delivery notice"),
   /**
    * Notification to the supplier regarding the termination
    * of a contract.
    */
   _406("Notification to supplier of contract termination"),
   /**
    * Notification to the supplier about changes regarding a
    * metering point.
    */
   _407("Notification to supplier of metering point changes"),
   /**
    * Notification about the change of a meter.
    */
   _408("Notification of meter change"),
   /**
    * Document/message containing instructions from a customer
    * to his bank to pay an amount in a specified currency to
    * a nominated party in another country by a method either
    * specified (e.g. teletransmission, air mail) or left to
    * the discretion of the bank.
    */
   _409("Instructions for bank transfer"),
   /**
    * Notification of the change of metering point
    * identification.
    */
   _410("Notification of metering point identification change"),
   /**
    * The Utilities time series message is sent between
    * responsible parties in a utilities infrastructure for
    * the purpose of reporting time series and connected
    * technical and/or administrative information.
    */
   _411("Utilities time series message"),
   /**
    * Application by a customer to his bank to issue a
    * banker's draft stating the amount and currency of the
    * draft, the name of the payee and the place and country
    * of payment.
    */
   _412("Application for banker's draft"),
   /**
    * Information about components in an infrastructure.
    */
   _413("Infrastructure condition"),
   /**
    * Acknowledgement of the change of supplier.
    */
   _414("Acknowledgement of change of supplier"),
   /**
    * Document/Message providing technical description and
    * information of the crop production.
    */
   _415("Data Plot Sheet"),
   /**
    * Soil analysis document.
    */
   _416("Soil analysis"),
   /**
    * Farmyard manure analysis document.
    */
   _417("Farmyard manure analysis"),
   /**
    * Declaration, in accordance with the WCO Customs Data
    * Model, to Customs concerning the export of cargo carried
    * by commercial means of transport over land, e.g. truck
    * or train.
    */
   _418("WCO Cargo Report Export, Rail or Road"),
   /**
    * Declaration, in accordance with the WCO Customs Data
    * Model, to Customs concerning the export of cargo carried
    * by commercial means of transport over water or through
    * the air, e.g. vessel or aircraft.
    */
   _419("WCO Cargo Report Export, Air or Maritime"),
   /**
    * Payment credit note effected by an Optical Character
    * Reading (OCR) document.
    */
   _420("Optical Character Reading (OCR) payment credit note"),
   /**
    * Declaration, in accordance with the WCO Customs Data
    * Model, to Customs concerning the import of cargo carried
    * by commercial means of transport over land, e.g. truck
    * or train.
    */
   _421("WCO Cargo Report Import, Rail or Road"),
   /**
    * Declaration, in accordance with the WCO Customs Data
    * Model, to Customs concerning the import of cargo carried
    * by commercial means of transport over water or through
    * the air, e.g. vessel or aircraft.
    */
   _422("WCO Cargo Report Import, Air or Maritime"),
   /**
    * Single step declaration, in accordance with the WCO
    * Customs Data Model, to Customs by which goods are
    * declared for a Customs export procedure based on the
    * 1999 Kyoto Convention.
    */
   _423("WCO one-step export declaration"),
   /**
    * First part of a simplified declaration, in accordance
    * with the WCO Customs Data Model, to Customs by which
    * goods are declared for Customs export procedure based on
    * the 1999 Kyoto Convention.
    */
   _424("WCO first step of two-step export declaration"),
   /**
    * Document/message whereby a bank advises that a
    * collection has been paid, giving details and methods of
    * funds disposal.
    */
   _425("Collection payment advice"),
   /**
    * Document/message whereby a bank advises payment under a
    * documentary credit.
    */
   _426("Documentary credit payment advice"),
   /**
    * Document/message whereby a bank advises acceptance under
    * a documentary credit.
    */
   _427("Documentary credit acceptance advice"),
   /**
    * Document/message whereby a bank advises negotiation
    * under a documentary credit.
    */
   _428("Documentary credit negotiation advice"),
   /**
    * Document/message whereby a customer requests his bank to
    * issue a guarantee in favour of a nominated party in
    * another country, stating the amount and currency and the
    * specific conditions of the guarantee.
    */
   _429("Application for banker's guarantee"),
   /**
    * Document/message in which a bank undertakes to pay out a
    * limited amount of money to a designated party, on
    * conditions stated therein (other than those laid down in
    * the Uniform Customs Practice).
    */
   _430("Banker's guarantee"),
   /**
    * Document/message in which a beneficiary of a documentary
    * credit accepts responsibility for non-compliance with
    * the terms and conditions of the credit, and undertakes
    * to refund the money received under the credit, with
    * interest and charges accrued.
    */
   _431("Documentary credit letter of indemnity"),
   /**
    * Notification to the grid operator regarding the
    * termination of a contract.
    */
   _432("Notification to grid operator of contract termination"),
   /**
    * Notification to the grid operator about changes
    * regarding a metering point.
    */
   _433("Notification to grid operator of metering point changes"),
   /**
    * Notification of a change of balance responsible entity.
    */
   _434("Notification of balance responsible entity change"),
   /**
    * Preadvice indicating a credit to happen in the future.
    */
   _435("Preadvice of a credit"),
   /**
    * Report on the profile of transport equipment.
    */
   _436("Transport equipment profile report"),
   /**
    * Document/message requesting price conditions and
    * delivery conditions under which goods are offered,
    * provided that they are sold to the end-customer
    * specified on the request for quote.
    */
   _437("Request for price and delivery quote, specified end-user"),
   /**
    * Document/message from a distributor to a supplier
    * requesting price conditions under which goods can be
    * sold by the distributor to the end-customer specified on
    * the request for quote with compensation for loss of
    * inventory value.
    */
   _438("Request for price quote, ship and debit"),
   /**
    * Document/message from a distributor to a supplier
    * requesting price conditions and delivery conditions
    * under which goods can be sold by the distributor to the
    * end-customer specified on the request for quote with
    * compensation for loss of inventory value.
    */
   _439("Request for price and delivery quote, ship and debit"),
   /**
    * A list of delivery point addresses.
    */
   _440("Delivery point list."),
   /**
    * Document specifying the routes for transport between
    * locations.
    */
   _441("Transport routing information"),
   /**
    * Document/message requesting delivery conditions under
    * which goods are offered.
    */
   _442("Request for delivery quote"),
   /**
    * Document/message requesting price and delivery
    * conditions under which goods are offered.
    */
   _443("Request for price and delivery quote"),
   /**
    * Document/message requesting contractual price conditions
    * under which goods are offered.
    */
   _444("Request for contract price quote"),
   /**
    * Document/message requesting contractual price conditions
    * and contractual delivery conditions under which goods
    * are offered.
    */
   _445("Request for contract price and delivery quote"),
   /**
    * Document/message requesting price conditions under which
    * goods are offered, provided that they are sold to the
    * end-customer specified on the request for quote.
    */
   _446("Request for price quote, specified end-customer"),
   /**
    * Document/message whereby a bank is instructed (or
    * requested) to handle financial and/or commercial
    * documents in order to obtain acceptance and/or payment,
    * or to deliver documents on such other terms and
    * conditions as may be specified.
    */
   _447("Collection order"),
   /**
    * Document/message whereby a draft or similar instrument
    * and/or commercial documents are presented to a bank for
    * acceptance, discounting, negotiation, payment or
    * collection, whether or not against a documentary credit.
    */
   _448("Documents presentation form"),
   /**
    * Message related to conducting a search for an
    * identification match.
    */
   _449("Identification match"),
   /**
    * Document/message containing information needed to
    * initiate the payment. It may cover the financial
    * settlement for one or more commercial trade
    * transactions. A payment order is an instruction to the
    * ordered bank to arrange for the payment of one specified
    * amount to the beneficiary.
    */
   _450("Payment order"),
   /**
    * Document/message containing information needed to
    * initiate the payment. It may cover the financial
    * settlement for several commercial trade transactions,
    * which it is possible to specify in a special payments
    * detail part. It is an instruction to the ordered bank to
    * arrange for the payment of one specified amount to the
    * beneficiary.
    */
   _451("Extended payment order"),
   /**
    * Document/message containing a payment order to debit one
    * or more accounts and to credit one or more
    * beneficiaries.
    */
   _452("Multiple payment order"),
   /**
    * goods
    * Message used to inform a supplier that delivered goods
    * cannot be paid due to circumstances which prevent
    * payment.
    */
   _453("Notice that circumstances prevent payment of delivered"),
   /**
    * Document/message sent by an account servicing
    * institution to one of its account owners, to inform the
    * account owner of an entry which has been or will be
    * credited to its account for a specified amount on the
    * date indicated.
    */
   _454("Credit advice"),
   /**
    * Document/message sent by an account servicing
    * institution to one of its account owners, to inform the
    * account owner of an entry that has been or will be
    * credited to its account for a specified amount on the
    * date indicated. It provides extended commercial
    * information concerning the relevant remittance advice.
    */
   _455("Extended credit advice"),
   /**
    * Advice on a debit.
    */
   _456("Debit advice"),
   /**
    * Reversal of debit accounting entry by bank.
    */
   _457("Reversal of debit"),
   /**
    * Reversal of credit accounting entry by bank.
    */
   _458("Reversal of credit"),
   /**
    * The document is a ticket giving access to a travel
    * service.
    */
   _459("Travel ticket"),
   /**
    * Document/message whereby a bank is requested to issue a
    * documentary credit on the conditions specified therein.
    */
   _460("Documentary credit application"),
   /**
    * The document is a credit, guarantee or charge card.
    */
   _461("Payment card"),
   /**
    * Document to advise that the goods ordered are ready for
    * transshipment.
    */
   _462("Ready for transshipment despatch advice"),
   /**
    * Document by means of which the supplier or consignor
    * informs the buyer, consignee or distribution centre
    * about the despatch of products packed according to the
    * final delivery point requirements which will be moved
    * across a dock in a distribution centre without further
    * handling.
    */
   _463("Pre-packed cross docking despatch advice"),
   /**
    * Document by means of which the supplier or consignor
    * informs the buyer, consignee or the distribution centre
    * about the despatch of products which will be moved
    * across a dock, de-consolidated and re-consolidated
    * according to final delivery location requirements.
    */
   _464("Intermediate handling cross docking despatch advice"),
   /**
    * Document/message in which a bank states that it has
    * issued a documentary credit under which the beneficiary
    * is to obtain payment, acceptance or negotiation on
    * compliance with certain terms and conditions and against
    * presentation of stipulated documents and such drafts as
    * may be specified. The credit may or may not be confirmed
    * by another bank.
    */
   _465("Documentary credit"),
   /**
    * Document/message issued by an advising bank in order to
    * transmit a documentary credit to a beneficiary, or to
    * another advising bank.
    */
   _466("Documentary credit notification"),
   /**
    * Document/message whereby a bank advises that (part of) a
    * documentary credit is being or has been transferred in
    * favour of a second beneficiary.
    */
   _467("Documentary credit transfer advice"),
   /**
    * Document/message whereby a bank advises that the terms
    * and conditions of a documentary credit have been
    * amended.
    */
   _468("Documentary credit amendment notification"),
   /**
    * Document/message whereby a bank notifies a beneficiary
    * of the details of an amendment to the terms and
    * conditions of a documentary credit.
    */
   _469("Documentary credit amendment"),
   /**
    * Document/message sent by a shipping agent to an
    * authority for reporting information on waste disposal.
    */
   _470("Waste disposal report"),
   /**
    * Document/message advising of the remittance of payment.
    */
   _481("Remittance advice"),
   /**
    * Document/message sent by a port authority to another
    * port authority for reporting information on waste
    * disposal.
    */
   _482("Port authority waste disposal report"),
   /**
    * An endorsement on a passport or any other recognised
    * travel document indicating that it has been examined and
    * found correct, especially as permitting the holder to
    * enter or leave a country.
    */
   _483("Visa"),
   /**
    * Document/message containing a direct debit request to
    * credit one or more accounts and to debit one or more
    * debtors.
    */
   _484("Multiple direct debit request"),
   /**
    * Draft drawn in favour of a third party either by one
    * bank on another bank, or by a branch of a bank on its
    * head office (or vice versa) or upon another branch of
    * the same bank. In either case, the draft should comply
    * with the specifications laid down for cheques in the
    * country in which it is to be payable.
    */
   _485("Banker's draft"),
   /**
    * Document/message containing a direct debit to credit one
    * or more accounts and to debit one or more debtors.
    */
   _486("Multiple direct debit"),
   /**
    * Document or message issuing permission to disembark.
    */
   _487("Certificate of disembarkation permission"),
   /**
    * Document certifying that the object was free of rats
    * when inspected and that it is exempt from a deratting
    * statement.
    */
   _488("Deratting exemption certificate"),
   /**
    * Order to connect a reefer container to a reefer point.
    */
   _489("Reefer connection order"),
   /**
    * Document/message, issued and signed in conformity with
    * the applicable legislation, which contains an
    * unconditional order whereby the drawer directs the
    * drawee to pay a definite sum of money to the payee or to
    * his order, on demand or at a definite time, against the
    * surrender of the document itself.
    */
   _490("Bill of exchange"),
   /**
    * Document/message, issued and signed in conformity with
    * the applicable legislation, which contains an
    * unconditional promise whereby the maker undertakes to
    * pay a definite sum of money to the payee or to his
    * order, on demand or at a definite time, against the
    * surrender of the document itself.
    */
   _491("Promissory note"),
   /**
    * Usage of STATAC-message.
    */
   _493("Statement of account message"),
   /**
    * Document/message ordering the direct delivery of
    * goods/consignment from one means of transport into
    * another means of transport in one movement.
    */
   _494("Direct delivery (transport)"),
   /**
    * Second part of a simplified declaration, in accordance
    * with the WCO Customs Data Model, to Customs by which
    * goods are declared for Customs export procedure based on
    * the 1999 Kyoto Convention.
    */
   _495("WCO second step of two-step export declaration"),
   /**
    * Single step declaration, in accordance with the WCO
    * Customs Data Model, to Customs by which goods are
    * declared for Customs import procedure based on the 1999
    * Kyoto Convention.
    */
   _496("WCO one-step import declaration"),
   /**
    * First part of a simplified declaration, in accordance
    * with the WCO Customs Data Model, to Customs by which
    * goods are declared for Customs import procedure based on
    * the 1999 Kyoto Convention.
    */
   _497("WCO first step of two-step import declaration"),
   /**
    * Second part of a simplified declaration, in accordance
    * with the WCO Customs Data Model, to Customs by which
    * goods are declared for Customs import procedure based on
    * the 1999 Kyoto Convention.
    */
   _498("WCO second step of two-step import declaration"),
   /**
    * Identification of the previous transport document.
    */
   _499("Previous transport document"),
   /**
    * Document/message issued to the insured certifying that
    * insurance has been effected and that a policy has been
    * issued. Such a certificate for a particular cargo is
    * primarily used when good are insured under the terms of
    * a floating or an open policy; at the request of the
    * insured it can be exchanged for a policy.
    */
   _520("Insurance certificate"),
   /**
    * cargo
    * A permit related to a transport document granting the
    * transport of cargo under the conditions as specifically
    * required.
    */
   _521("Special requirements permit related to the transport of"),
   /**
    * Dangerous Goods Notification for a vessel carrying
    * liquid cargo in bulk.
    */
   _522("Dangerous Goods Notification for Tanker vessel"),
   /**
    * Dangerous Goods Notification for a vessel carrying cargo
    * other than bulk liquid cargo.
    */
   _523("Dangerous Goods Notification for non-tanker vessel"),
   /**
    * Declaration, in accordance with the WCO Customs Data
    * Model, to Customs regarding the conveyance arriving in a
    * Customs territory.
    */
   _524("WCO Conveyance Arrival Report"),
   /**
    * Declaration, in accordance with the WCO Customs Data
    * Model, to Customs regarding the conveyance departing a
    * Customs territory.
    */
   _525("WCO Conveyance Departure Report"),
   /**
    * A document/message justifying an accounting entry.
    */
   _526("Accounting voucher"),
   /**
    * A document which indicates that the customer is claiming
    * debit in a self billing environment.
    */
   _527("Self billed debit note"),
   /**
    * The official document used for military personnel on
    * travel orders, substituting a passport.
    */
   _528("Military Identification Card"),
   /**
    * A permit to re-enter a country.
    */
   _529("Re-Entry Permit"),
   /**
    * Document/message issued by the insurer evidencing an
    * agreement to insure and containing the conditions of the
    * agreement concluded whereby the insurer undertakes for a
    * specific fee to indemnify the insured for the losses
    * arising out of the perils and accidents specified in the
    * contract.
    */
   _530("Insurance policy"),
   /**
    * Document identifying a refugee recognized by a country.
    */
   _531("Refugee Permit"),
   /**
    * Document/message for providing credit information to the
    * relevant party.
    */
   _532("Forwarder’s credit note"),
   /**
    * To indicate that the document/message justifying an
    * accounting entry is original.
    */
   _533("Original accounting voucher"),
   /**
    * To indicate that the document/message justifying an
    * accounting entry is a copy.
    */
   _534("Copy accounting voucher"),
   /**
    * To indicate that the document/message justifying an
    * accounting entry is pro-forma.
    */
   _535("Pro-forma accounting voucher"),
   /**
    * A certificate on ship security issued based on the
    * International code for the Security of Ships and of Port
    * facilities (ISPS code).
    */
   _536("International Ship Security Certificate"),
   /**
    * An interim certificate on ship security issued basis
    * under the International code for the Security of Ships
    * and of Port facilities (ISPS code).
    */
   _537("Interim International Ship Security Certificate"),
   /**
    * Certificate that guarantees quality manufacturing and
    * processing of food products, medications, cosmetics,
    * etc.
    */
   _538("Good Manufacturing Practice (GMP) Certificate"),
   /**
    * An agreement between one or more contracting authorities
    * and one or more economic operators, the purpose of which
    * is to establish the terms governing contracts to be
    * awarded during a given period, in particular with regard
    * to price and, where appropriate, the quantity envisaged.
    */
   _539("Framework Agreement"),
   /**
    * A document/message used when an insured reports to his
    * insurer details of individual shipments which are
    * covered by an insurance contract - an open cover or a
    * floating policy - between the parties.
    */
   _550("Insurance declaration sheet (bordereau)"),
   /**
    * Offering of capacity for the transport of goods for a
    * date and a route.
    */
   _551("Transport capacity offer"),
   /**
    * Ship Security Plan (SSP) is a document prepared in terms
    * of the ISPS Code to contribute to the prevention of
    * illegal acts against the ship and its crew.
    */
   _552("Ship Security Plan"),
   /**
    * Document/message reporting invoice discrepancies
    * indentified by the forwarder.
    */
   _553("Forwarder’s invoice discrepancy report"),
   /**
    * Offering of capacity to store goods.
    */
   _554("Storage capacity offer"),
   /**
    * Document/message issued by an insurer specifying the
    * cost of an insurance which has been effected and
    * claiming payment therefore.
    */
   _575("Insurer's invoice"),
   /**
    * Request for capacity to store goods.
    */
   _576("Storage capacity request"),
   /**
    * Request for capacity for the transport of goods for a
    * date and a route.
    */
   _577("Transport capacity request"),
   /**
    * Customs declaration for goods under the external
    * Community/common transit procedure. This applies to
    * "non-Community goods" ("T1" under EU legislation and EC-
    * EFTA "Transit Convention").
    */
   _578("EU Customs declaration for External Community Transit (T1)"),
   /**
    * Customs declaration for goods under the internal
    * Community/common transit procedure. This applies to
    * "Community goods" ("T2" under EU legislation and EC-EFTA
    * "Transit Convention").
    */
   _579("EU Customs declaration for internal Community Transit (T2)"),
   /**
    * Document/message issued by an insurer (insurance broker,
    * agent, etc.) to notify the insured that his insurance
    * have been carried out.
    */
   _580("Cover note"),
   /**
    * Community Transit (T2F)
    * Declaration for goods under the internal Community
    * transit procedure in the context of trade between the
    * "VAT" territory of EU Member States and EU territories
    * where the VAT rules do not apply, such as Canary
    * islands, some French overseas territories, the Channel
    * islands and the Aaland islands, and between those
    * territories. ("T2F" under EU Legislation).
    */
   _581("EU Customs declaration for non-fiscal area internal"),
   /**
    * (T2SM)
    * Customs declaration for goods under the internal
    * Community transit procedure between the Community and
    * San Marino. ("T2SM" under EU Legislation).
    */
   _582("EU Customs declaration for internal transit to San Marino"),
   /**
    * Customs declaration for goods under the Community/common
    * transit procedure for mixed consignments (i.e.
    * consignments that comprise goods of different statuses,
    * like "T1" and "T2") ("T" under EU Legislation).
    */
   _583("EU Customs declaration for mixed consignments (T)"),
   /**
    * (T2L)
    * Form establishing the Community status of goods ("T2L"
    * under EU Legislation).
    */
   _584("EU Document for establishing the Community status of goods"),
   /**
    * for certain fiscal purposes (T2LF)
    * Form establishing the Community status of goods in the
    * context of trade between the "VAT" territory of EU
    * Member States and EU territories where the VAT rules do
    * not apply, such as Canary islands, some French overseas
    * territories, the Channel islands and the Aaland islands,
    * and between those territories ("T2LF" under EU
    * Legislation).
    */
   _585("EU Document for establishing the Community status of goods"),
   /**
    * San Marino (T2LSM)
    * Form establishing the Community status of goods ("T2L"
    * under European Legislation) in the context of trade
    * between the EU and San Marino. ("T2LSM" under EU
    * Legislation).
    */
   _586("Document for establishing the Customs Status of goods for"),
   /**
    * A Customs declaration in which goods move under cover of
    * TIR Carnets.
    */
   _587("Customs declaration for TIR Carnet goods"),
   /**
    * A document reporting the security status and related
    * information of a means of transport.
    */
   _588("Transport Means Security Report"),
   /**
    * A certificate verifying that meat has been produced from
    * slaughter in accordance with Islamic laws and practices.
    */
   _589("Halal Slaughtering Certificate"),
   /**
    * Document/message issued to a freight forwarder, giving
    * instructions regarding the action to be taken by the
    * forwarder for the forwarding of goods described therein.
    */
   _610("Forwarding instructions"),
   /**
    * Document/message issued by a freight forwarder in an
    * exporting country advising his counterpart in an
    * importing country about the forwarding of goods
    * described therein.
    */
   _621("Forwarder's advice to import agent"),
   /**
    * Document/message issued by a freight forwarder informing
    * an exporter of the action taken in fulfillment of
    * instructions received.
    */
   _622("Forwarder's advice to exporter"),
   /**
    * Invoice issued by a freight forwarder specifying
    * services rendered and costs incurred and claiming
    * payment therefore.
    */
   _623("Forwarder's invoice"),
   /**
    * Non-negotiable document issued by a forwarder to certify
    * that he has assumed control of a specified consignment,
    * with irrevocable instructions to send it to the
    * consignee indicated in the document or to hold it at his
    * disposal. E.g. FIATA-FCR.
    */
   _624("Forwarder's certificate of receipt"),
   /**
    * A certificate verifying the heat treatment of the
    * product is in conformance with international standards
    * to ensure the product’s healthiness and/or shows the
    * mode of heat treatment indicating the temperature and
    * the amount of time the product or raw material used in
    * the product was treated (such as milk).
    */
   _625("Heat Treatment Certificate"),
   /**
    * Wild Fauna and Flora (CITES) Certificate
    * A certificate used in the trade of endangered species in
    * accordance with the CITES convention.
    */
   _626("Convention on International Trade in Endangered Species of"),
   /**
    * A certificate confirming that a specified product is
    * free for sale in the country of origin.
    */
   _627("Free Sale Certificate in the Country of Origin"),
   /**
    * Document/message issued by the competent body in
    * accordance with transit regulations in force, by which
    * authorization is granted to a party to move articles
    * under customs procedure.
    */
   _628("Transit license"),
   /**
    * A certification that livestock or animal products, that
    * are either imported or entering free zones, are kept
    * under health supervision for a time period determined by
    * veterinary quarantine instructions.
    */
   _629("Veterinary quarantine certificate"),
   /**
    * (1123) Document/message provided by the shipper or his
    * agent to the carrier, multimodal transport operator,
    * terminal or other receiving authority, giving
    * information about export consignments offered for
    * transport, and providing for the necessary receipts and
    * declarations of liability. Sometimes a multipurpose
    * cargo handling document also fulfilling the functions of
    * document 632, 633, 650 and 655.
    */
   _630("Shipping note"),
   /**
    * Document/message issued by a forwarder acting as
    * Warehouse Keeper acknowledging receipt of goods placed
    * in a warehouse, and stating or referring to the
    * conditions which govern the warehousing and the release
    * of goods. The document contains detailed provisions
    * regarding the rights of holders-by-endorsement, transfer
    * of ownership, etc. E.g. FIATA-FWR.
    */
   _631("Forwarder's warehouse receipt"),
   /**
    * Document/message to acknowledge the receipt of goods and
    * in addition may indicate receiving conditions.
    */
   _632("Goods receipt"),
   /**
    * Documents/messages specifying services rendered, storage
    * and handling costs, demurrage and other charges due to
    * the owner of goods described therein.
    */
   _633("Port charges documents"),
   /**
    * A document legalized from a competent authority that
    * shows the components of the product (food additive,
    * detergent, disinfectant and sanitizer).
    */
   _634("Certified list of ingredients"),
   /**
    * Negotiable receipt document, issued by a Warehouse
    * Keeper to a person placing goods in a warehouse and
    * conferring title to the goods stored.
    */
   _635("Warehouse warrant"),
   /**
    * A document legalized from a competent authority that
    * shows that the product has been tested microbiologically
    * and is free from any pathogens and fit for human
    * consumption and/or declares that the product is in
    * compliance with sanitary and phytosanitary measures.
    */
   _636("Health certificate"),
   /**
    * A document that shows that the product (food additive,
    * detergent, disinfectant and sanitizer) is suitable to be
    * used in the food industry.
    */
   _637("Food grade certificate"),
   /**
    * legumes
    * Certificate of inspection for the vessel stating its
    * readiness and suitability for transporting grains and
    * legumes.
    */
   _638("Certificate of suitability for transport of grains and"),
   /**
    * Inspection document shows that the container, the
    * cooling devices and measured temperature is in good
    * working condition.
    */
   _639("Certificate of refrigerated transport equipment inspection"),
   /**
    * Document/message issued by a party entitled to authorize
    * the release of goods specified therein to a named
    * consignee, to be retained by the custodian of the goods.
    */
   _640("Delivery order"),
   /**
    * A report of temperature readings over a period.
    */
   _641("Thermographic reading report"),
   /**
    * A certificate to verify readiness of a transport or
    * transport area such as a reservoir or hold to transport
    * food items.
    */
   _642("Certificate of food item transport readiness"),
   /**
    * A document legalized from a competent authority that
    * shows that the food packaging product is safe to come
    * into contact with food.
    */
   _643("Food packaging contact certificate"),
   /**
    * A document that shows the main structure that composes
    * the packaging material.
    */
   _644("Packaging material composition report"),
   /**
    * A certification executed by the competent authority from
    * country of exportation stating the export price of the
    * goods.
    */
   _645("Export price certificate"),
   /**
    * A certification executed by the competent authority from
    * country of production stating the price of the goods to
    * the general public.
    */
   _646("Public price certificate"),
   /**
    * A document containing results from the study which
    * determines the shelf life, namely the time period of
    * storage at a specified condition within which a drug
    * substance or drug product still meets its established
    * specifications; its identity, strength, quality and
    * purity.
    */
   _647("Drug shelf life study report"),
   /**
    * Organization for Animal Health (OIE)
    * A certification that the products have been treated in a
    * way consistent with the standards set by the World
    * Organization for Animal Health (OIE).
    */
   _648("Certificate of compliance with standards of the World"),
   /**
    * A license granted by a competent authority to a
    * production facility for manufacturing specific products.
    */
   _649("Production facility license"),
   /**
    * Document/message issued by a cargo handling organization
    * (port administration, terminal operator, etc.) for the
    * removal or other handling of goods under their care.
    */
   _650("Handling order"),
   /**
    * A license granted by a competent authority to a
    * manufacturer for production of specific products.
    */
   _651("Manufacturing license"),
   /**
    * An official letter issued by an import authority granted
    * to the importer of goods from a low risk country which
    * allows the importer to place its products in the local
    * market with certain favorable considerations.
    */
   _652("Low risk country formal letter"),
   /**
    * Correspondence previously exchanged.
    */
   _653("Previous correspondence"),
   /**
    * A declaration to be presented to the competent authority
    * when radioactive material moves cross-border.
    */
   _654("Declaration for radioactive material"),
   /**
    * Document/message authorizing goods specified therein to
    * be brought out of a fenced-in port or terminal area.
    */
   _655("Gate pass"),
   /**
    * Document/message providing information on a resale.
    */
   _656("Resale information"),
   /**
    * A message/document consistent with the model for re-
    * export phytosanitary certificates of the IPPC, attesting
    * that a consignment meets phytosanitary import
    * requirements.
    */
   _657("Phytosanitary Re-export Certificate"),
   /**
    * A full bayplan containing all occupied and/or blocked
    * stowage locations.
    */
   _658("Bayplan/stowage plan, full"),
   /**
    * A partial bayplan. containing only a selected part of
    * the available stowage locations.
    */
   _659("Bayplan/stowage plan, partial"),
   /**
    * Non-negotiable document evidencing the contract for the
    * transport of cargo.
    */
   _700("Waybill"),
   /**
    * Document/message evidencing a contract of carriage
    * covering the movement of goods by any mode of transport,
    * or combination of modes, for national as well as
    * international transport, under any applicable
    * international convention or national law and under the
    * conditions of carriage of any carrier or transport
    * operator undertaking or arranging the transport referred
    * to in the document.
    */
   _701("Universal (multipurpose) transport document"),
   /**
    * Document/message issued by a carrier or a carrier's
    * agent, acknowledging receipt for carriage of goods
    * specified therein on conditions stated or referred to in
    * the document, enabling the carrier to issue a transport
    * document.
    */
   _702("Goods receipt, carriage"),
   /**
    * The document made out by an agent/consolidator which
    * evidences the contract between the shipper and the
    * agent/consolidator for the arrangement of carriage of
    * goods.
    */
   _703("House waybill"),
   /**
    * A bill of lading issued by the master of a vessel (in
    * actuality the owner or charterer of the vessel). It
    * could cover a number of house bills.
    */
   _704("Master bill of lading"),
   /**
    * Negotiable document/message which evidences a contract
    * of carriage by sea and the taking over or loading of
    * goods by carrier, and by which carrier undertakes to
    * deliver goods against surrender of the document. A
    * provision in the document that goods are to be delivered
    * to the order of a named person, or to order, or to
    * bearer, constitutes such an undertaking.
    */
   _705("Bill of lading"),
   /**
    * The original of the bill of lading issued by a transport
    * company. When issued by the maritime industry it could
    * signify ownership of the cargo.
    */
   _706("Bill of lading original"),
   /**
    * A copy of the bill of lading issued by a transport
    * company.
    */
   _707("Bill of lading copy"),
   /**
    * Bill of lading indicating an empty container.
    */
   _708("Empty container bill"),
   /**
    * Document which evidences a transport of liquid bulk
    * cargo.
    */
   _709("Tanker bill of lading"),
   /**
    * Non-negotiable document which evidences a contract for
    * the carriage of goods by sea and the taking over of the
    * goods by the carrier, and by which the carrier
    * undertakes to deliver the goods to the consignee named
    * in the document.
    */
   _710("Sea waybill"),
   /**
    * Negotiable transport document made out to a named
    * person, to order or to bearer, signed by the carrier and
    * handed to the sender after receipt of the goods.
    */
   _711("Inland waterway bill of lading"),
   /**
    * Non-negotiable document which evidences a contract for
    * the carriage of goods by sea and the taking over or
    * loading of the goods by the carrier, and by which the
    * carrier undertakes to deliver the goods to the consignee
    * named in the document. E.g. Sea waybill. Remark:
    * Synonymous with "straight" or "non-negotiable Bill of
    * lading" used in certain countries, e.g. Canada.
    */
   _712("Non-negotiable maritime transport document (generic)"),
   /**
    * Document/message issued by a ship's officer to
    * acknowledge that a specified consignment has been
    * received on board a vessel, and the apparent condition
    * of the goods; enabling the carrier to issue a Bill of
    * lading.
    */
   _713("Mate's receipt"),
   /**
    * The bill of lading issued not by the carrier but by the
    * freight forwarder/consolidator known by the carrier.
    */
   _714("House bill of lading"),
   /**
    * Document/message issued by a commercial party or a bank
    * of an insurance company accepting responsibility to the
    * beneficiary of the indemnity in accordance with the
    * terms thereof.
    */
   _715("Letter of indemnity for non-surrender of bill of lading"),
   /**
    * Non-negotiable document issued by a freight forwarder
    * evidencing a contract for the carriage of goods by sea
    * and the taking over or loading of the goods by the
    * freight forwarder, and by which the freight forwarder
    * undertakes to deliver the goods to the consignee named
    * in the document.
    */
   _716("Forwarder's bill of lading"),
   /**
    * Transport document constituting a contract for the
    * carriage of goods between the sender and the carrier
    * (the railway). For international rail traffic, this
    * document must conform to the model prescribed by the
    * international conventions concerning carriage of goods
    * by rail, e.g. CIM Convention, SMGS Convention.
    */
   _720("Rail consignment note (generic term)"),
   /**
    * Accounting document, one copy of which is drawn up for
    * each consignment note; it accompanies the consignment
    * over the whole route and is a rail transport document.
    */
   _722("Road list-SMGS"),
   /**
    * Document/message which gives right to the owner to exert
    * all functions normally transferred to a guard in a train
    * by which an escorted consignment is transported.
    */
   _723("Escort official recognition"),
   /**
    * Fictitious transport document regarding a previous
    * transport, enabling a carrier's agent to give to another
    * carrier's agent (in a different country) the possibility
    * to collect charges relating to the original transport
    * (rail environment).
    */
   _724("Recharging document"),
   /**
    * Transport document/message which evidences a contract
    * between a carrier and a sender for the carriage of goods
    * by road (generic term). Remark: For international road
    * traffic, this document must contain at least the
    * particulars prescribed by the convention on the contract
    * for the international carriage of goods by road (CMR).
    */
   _730("Road consignment note"),
   /**
    * Document/message made out by or on behalf of the shipper
    * which evidences the contract between the shipper and
    * carrier(s) for carriage of goods over routes of the
    * carrier(s) and which is identified by the airline prefix
    * issuing the document plus a serial (IATA).
    */
   _740("Air waybill"),
   /**
    * Document/message made out by or on behalf of the
    * agent/consolidator which evidences the contract between
    * the agent/consolidator and carrier(s) for carriage of
    * goods over routes of the carrier(s) for a consignment
    * consisting of goods originated by more than one shipper
    * (IATA).
    */
   _741("Master air waybill"),
   /**
    * A temporary air waybill which contains only limited
    * information because of the absence of the original.
    */
   _743("Substitute air waybill"),
   /**
    * Declaration to Customs regarding the personal effects of
    * crew members aboard the conveyance; equivalent to IMO
    * FAL 4.
    */
   _744("Crew's effects declaration"),
   /**
    * Declaration to Customs regarding passengers aboard the
    * conveyance; equivalent to IMO FAL 6.
    */
   _745("Passenger list"),
   /**
    * Document/message created by the consignor or by the
    * departure station, joined to the transport or sent to
    * the consignee, giving the possibility to the consignee
    * or the arrival station to attest the delivery of the
    * goods. The document must be returned to the consignor or
    * to the departure station.
    */
   _746("Delivery notice (rail transport)"),
   /**
    * Document/message which, according to Article 106 of the
    * "Agreement concerning Postal Parcels" under the UPU
    * convention, is to accompany post parcels.
    */
   _750("Despatch note (post parcels)"),
   /**
    * A transport document used when more than one mode of
    * transportation is involved in the movement of cargo. It
    * is a contract of carriage and receipt of the cargo for a
    * multimodal transport. It indicates the place where the
    * responsible transport company in the move takes
    * responsibility for the cargo, the place where the
    * responsibility of this transport company in the move
    * ends and the conveyances involved.
    */
   _760("Multimodal/combined transport document (generic)"),
   /**
    * Bill of lading which evidences a contract of carriage
    * from one place to another in separate stages of which at
    * least one stage is a sea transit, and by which the
    * issuing carrier accepts responsibility for the carriage
    * as set forth in the through bill of lading.
    */
   _761("Through bill of lading"),
   /**
    * Negotiable document/message issued by a forwarder to
    * certify that he has taken charge of a specified
    * consignment for despatch and delivery in accordance with
    * the consignor's instructions, as indicated in the
    * document, and that he accepts responsibility for
    * delivery of the goods to the holder of the document
    * through the intermediary of a delivery agent of his
    * choice. E.g. FIATA-FCT.
    */
   _763("Forwarder's certificate of transport"),
   /**
    * Negotiable or non-negotiable document evidencing a
    * contract for the performance and/or procurement of
    * performance of combined transport of goods and bearing
    * on its face either the heading "Negotiable combined
    * transport document issued subject to Uniform Rules for a
    * Combined Transport Document (ICC Brochure No. 298)" or
    * the heading "Non-negotiable Combined Transport Document
    * issued subject to Uniform Rules for a Combined Transport
    * Document (ICC Brochure No. 298)".
    */
   _764("Combined transport document (generic)"),
   /**
    * Document/message which evidences a multimodal transport
    * contract, the taking in charge of the goods by the
    * multimodal transport operator, and an undertaking by him
    * to deliver the goods in accordance with the terms of the
    * contract. (International Convention on Multimodal
    * Transport of Goods).
    */
   _765("Multimodal transport document (generic)"),
   /**
    * Document which evidences a multimodal transport
    * contract, the taking in charge of the goods by the
    * multimodal transport operator, and an undertaking by him
    * to deliver the goods in accordance with the terms of the
    * contract.
    */
   _766("Combined transport bill of lading/multimodal bill of lading"),
   /**
    * Document/message issued by a carrier to confirm that
    * space has been reserved for a consignment in means of
    * transport.
    */
   _770("Booking confirmation"),
   /**
    * Instructions for release or delivery of goods.
    */
   _775("Calling forward notice"),
   /**
    * Document/message issued by a transport operation
    * specifying freight costs and charges incurred for a
    * transport operation and stating conditions of payment.
    */
   _780("Freight invoice"),
   /**
    * Notification from the carrier to the consignee in
    * writing, by telephone or by any other means (express
    * letter, message, telegram, etc.) informing him that a
    * consignment addressed to him is being or will shortly be
    * held at his disposal at a specified point in the place
    * of destination.
    */
   _781("Arrival notice (goods)"),
   /**
    * Request made by the carrier to the sender, or, as the
    * case may be, the consignee, for instructions as to the
    * disposal of the consignment when circumstances prevent
    * delivery and the return of the goods has not been
    * requested by the consignor in the transport document.
    */
   _782("Notice of circumstances preventing delivery (goods)"),
   /**
    * Request made by the carrier to the sender, or, the
    * consignee as the case may be, for instructions as to the
    * disposal of the goods when circumstances prevent
    * transport before departure or en route, after acceptance
    * of the consignment concerned.
    */
   _783("Notice of circumstances preventing transport (goods)"),
   /**
    * Notification in writing, sent by the carrier to the
    * sender, to inform him at his request of the actual date
    * of delivery of the goods.
    */
   _784("Delivery notice (goods)"),
   /**
    * Listing of goods comprising the cargo carried in a means
    * of transport or in a transport-unit. The cargo manifest
    * gives the commercial particulars of the goods, such as
    * transport document numbers, consignors, consignees,
    * shipping marks, number and kind of packages and
    * descriptions and quantities of the goods.
    */
   _785("Cargo manifest"),
   /**
    * Document/message containing the same information as a
    * cargo manifest, and additional details on freight
    * amounts, charges, etc.
    */
   _786("Freight manifest"),
   /**
    * Document/message used in road transport, listing the
    * cargo carried on a road vehicle, often referring to
    * appended copies of Road consignment note.
    */
   _787("Bordereau"),
   /**
    * Document/message specifying the contents of particular
    * freight containers or other transport units, prepared by
    * the party responsible for their loading into the
    * container or unit.
    */
   _788("Container manifest (unit packing list)"),
   /**
    * Document used by the rail organization to indicate
    * freight charges or additional charges in each case where
    * the departure station is not able to calculate the
    * charges for the total voyage (e.g. tariff not yet
    * updated, part of voyage not covered by the tariff). This
    * document must be considered as joined to the transport.
    */
   _789("Charges note"),
   /**
    * (1030) Document that is joined to the transport or sent
    * by separate means, giving to the departure rail
    * organization the proof that the cash-on delivery amount
    * has been encashed by the arrival rail organization
    * before reimbursement of the consignor.
    */
   _790("Advice of collection"),
   /**
    * Document certifying a ship's safety to a specified date.
    */
   _791("Safety of ship certificate"),
   /**
    * Document certifying the safety of a ship's radio
    * facilities to a specified date.
    */
   _792("Safety of radio certificate"),
   /**
    * Document certifying the safety of a ship's equipment to
    * a specified date.
    */
   _793("Safety of equipment certificate"),
   /**
    * Document declaring a ship owner's liability for oil
    * propelling or carried on a vessel.
    */
   _794("Civil liability for oil certificate"),
   /**
    * Document specifying the limit of a ship's legal
    * submersion under various conditions.
    */
   _795("Loadline document"),
   /**
    * Document certifying that a ship is free of rats, valid
    * to a specified date.
    */
   _796("Derat document"),
   /**
    * Document certifying the health condition on board a
    * vessel, valid to a specified date.
    */
   _797("Maritime declaration of health"),
   /**
    * Official certificate stating the vessel's registry.
    */
   _798("Certificate of registry"),
   /**
    * Declaration to Customs regarding the contents of the
    * ship's stores (equivalent to IMO FAL 3) i.e. goods
    * intended for consumption by passengers/crew on board
    * vessels, aircraft or trains, whether or not sold or
    * landed; goods necessary for operation/maintenance of
    * conveyance, including fuel/lubricants, excluding spare
    * parts/equipment (IMO).
    */
   _799("Ship's stores declaration"),
   /**
    * Application for a permit issued by a government
    * authority permitting exportation of a specified
    * commodity subject to specified conditions as quantity,
    * country of destination, etc.
    */
   _810("Export licence, application for"),
   /**
    * Permit issued by a government authority permitting
    * exportation of a specified commodity subject to
    * specified conditions as quantity, country of
    * destination, etc. Synonym: Embargo permit.
    */
   _811("Export licence"),
   /**
    * Document/message completed by an exporter/seller as a
    * means whereby the competent body may control that the
    * amount of foreign exchange accrued from a trade
    * transaction is repatriated in accordance with the
    * conditions of payment and exchange control regulations
    * in force.
    */
   _812("Exchange control declaration, export"),
   /**
    * European community transit declaration.
    */
   _820("Despatch note model T"),
   /**
    * Transit declaration for goods circulating under internal
    * community transit procedures (between European Union
    * (EU) countries).
    */
   _821("Despatch note model T1"),
   /**
    * Ascertainment that the declared goods were originally
    * produced in an European Union (EU) country.
    */
   _822("Despatch note model T2"),
   /**
    * Control document (export declaration) used particularly
    * in case of re-sending without use with only VAT
    * collection, refusal, unconformity with contract etc.
    */
   _823("Control document T5"),
   /**
    * Rail consignment note prepared by the consignor for the
    * facilitation of an eventual return to the origin of the
    * goods.
    */
   _824("Re-sending consignment note"),
   /**
    * Ascertainment that the declared goods were originally
    * produced in an European Union (EU) country. May only be
    * used for goods that are loaded on one single means of
    * transport in one single departure point for one single
    * delivery point.
    */
   _825("Despatch note model T2L"),
   /**
    * Document/message by which goods are declared for export
    * Customs clearance, conforming to the layout key set out
    * at Appendix I to Annex C.1 concerning outright
    * exportation to the Kyoto convention (CCC). Within a
    * Customs union, "for despatch" may have the same meaning
    * as "for exportation".
    */
   _830("Goods declaration for exportation"),
   /**
    * Generic term, sometimes referred to as Freight
    * declaration, applied to the documents providing the
    * particulars required by the Customs concerning the cargo
    * (freight) carried by commercial means of transport
    * (CCC).
    */
   _833("Cargo declaration (departure)"),
   /**
    * Document/message submitted to a competent body by party
    * requesting a Goods control certificate to be issued in
    * accordance with national or international standards, or
    * conforming to legislation in the importing country, or
    * as specified in the contract.
    */
   _840("Application for goods control certificate"),
   /**
    * Document/message issued by a competent body evidencing
    * the quality of the goods described therein, in
    * accordance with national or international standards, or
    * conforming to legislation in the importing country, or
    * as specified in the contract.
    */
   _841("Goods control certificate"),
   /**
    * Document/message submitted to a competent body by party
    * requesting a Phytosanitary certificate to be issued.
    */
   _850("Application for phytosanitary certificate"),
   /**
    * A message/doucment consistent with the model for
    * certificates of the IPPC, attesting that a consignment
    * meets phytosanitary import requirements.
    */
   _851("Phytosanitary certificate"),
   /**
    * Document/message issued by the competent authority in
    * the exporting country evidencing that alimentary and
    * animal products, including dead animals, are fit for
    * human consumption, and giving details, when relevant, of
    * controls undertaken.
    */
   _852("Sanitary certificate"),
   /**
    * Document/message issued by the competent authority in
    * the exporting country evidencing that live animals or
    * birds are not infested or infected with disease, and
    * giving details regarding their provenance, and of
    * vaccinations and other treatment to which they have been
    * subjected.
    */
   _853("Veterinary certificate"),
   /**
    * Document/message submitted to a competent body by a
    * party requesting an Inspection certificate to be issued
    * in accordance with national or international standards,
    * or conforming to legislation in the country in which it
    * is required, or as specified in the contract.
    */
   _855("Application for inspection certificate"),
   /**
    * Document/message issued by a competent body evidencing
    * that the goods described therein have been inspected in
    * accordance with national or international standards, in
    * conformity with legislation in the country in which the
    * inspection is required, or as specified in the contract.
    */
   _856("Inspection certificate"),
   /**
    * Document/message submitted to a competent body by an
    * interested party requesting a Certificate of origin to
    * be issued in accordance with relevant criteria, and on
    * the basis of evidence of the origin of the goods.
    */
   _860("Certificate of origin, application for"),
   /**
    * Document/message identifying goods, in which the
    * authority or body authorized to issue it certifies
    * expressly that the goods to which the certificate
    * relates originate in a specific country. The word
    * "country" may include a group of countries, a region or
    * a part of a country. This certificate may also include a
    * declaration by the manufacturer, producer, supplier,
    * exporter or other competent person.
    */
   _861("Certificate of origin"),
   /**
    * Appropriate statement as to the origin of the goods,
    * made in connection with their exportation by the
    * manufacturer, producer, supplier, exporter or other
    * competent person on the Commercial invoice or any other
    * document relating to the goods (CCC).
    */
   _862("Declaration of origin"),
   /**
    * Certificate drawn up in accordance with the rules laid
    * down by an authority or approved body, certifying that
    * the goods described therein qualify for a designation
    * specific to the given region (e.g. champagne, port wine,
    * Parmesan cheese).
    */
   _863("Regional appellation certificate"),
   /**
    * Document/message describing a certificate of origin
    * meeting the requirements for preferential treatment.
    */
   _864("Preference certificate of origin"),
   /**
    * Specific form of certificate of origin for goods
    * qualifying for preferential treatment under the
    * generalized system of preferences (includes a combined
    * declaration of origin and certificate, form A).
    */
   _865("Certificate of origin form GSP"),
   /**
    * Document/message to be prepared by an exporter in his
    * country and presented to a diplomatic representation of
    * the importing country for endorsement and subsequently
    * to be presented by the importer in connection with the
    * import of the goods described therein.
    */
   _870("Consular invoice"),
   /**
    * (1115) Document/message issued by a consignor in
    * accordance with applicable conventions or regulations,
    * describing hazardous goods or materials for transport
    * purposes, and stating that the latter have been packed
    * and labelled in accordance with the provisions of the
    * relevant conventions or regulations.
    */
   _890("Dangerous goods declaration"),
   /**
    * Document/message in which an exporter provides
    * information about exported goods required by the body
    * responsible for the collection of international trade
    * statistics.
    */
   _895("Statistical document, export"),
   /**
    * Document/message in which a declarant provides
    * information about goods required by the body responsible
    * for the collection of trade statistics.
    */
   _896("INTRASTAT declaration"),
   /**
    * Document/message whereby an official authority (Customs
    * or governmental) certifies that goods have been
    * delivered.
    */
   _901("Delivery verification certificate"),
   /**
    * Document/message in which an interested party applies to
    * the competent body for authorization to import either a
    * limited quantity of articles subject to import
    * restrictions, or an unlimited quantity of such articles
    * during a limited period, and specifies the kind of
    * articles, their origin and value, etc.
    */
   _910("Import licence, application for"),
   /**
    * Document/message issued by the competent body in
    * accordance with import regulations in force, by which
    * authorization is granted to a named party to import
    * either a limited quantity of designated articles or an
    * unlimited quantity of such articles during a limited
    * period, under conditions specified in the document.
    */
   _911("Import licence"),
   /**
    * CUSDEC transmission that does not include data from the
    * commercial detail section of the message.
    */
   _913("Customs declaration without commercial detail"),
   /**
    * CUSDEC transmission that includes data from both the
    * commercial detail and item detail sections of the
    * message.
    */
   _914("Customs declaration with commercial and item detail"),
   /**
    * CUSDEC transmission that does not include data from the
    * item detail section of the message.
    */
   _915("Customs declaration without item detail"),
   /**
    * Document that has a relationship with the stated
    * document/message.
    */
   _916("Related document"),
   /**
    * Receipt for Customs duty/tax/fee paid.
    */
   _917("Receipt (Customs)"),
   /**
    * Document/message whereby an importer/buyer requests the
    * competent body to allocate an amount of foreign exchange
    * to be transferred to an exporter/seller in payment for
    * goods.
    */
   _925("Application for exchange allocation"),
   /**
    * Document/message issued by the competent body
    * authorizing an importer/buyer to transfer an amount of
    * foreign exchange to an exporter/seller in payment for
    * goods.
    */
   _926("Foreign exchange permit"),
   /**
    * Document/message completed by an importer/buyer as a
    * means for the competent body to control that a trade
    * transaction for which foreign exchange has been
    * allocated has been executed and that money has been
    * transferred in accordance with the conditions of payment
    * and the exchange control regulations in force.
    */
   _927("Exchange control declaration (import)"),
   /**
    * Document/message by which goods are declared for import
    * Customs clearance [sister entry of 830].
    */
   _929("Goods declaration for importation"),
   /**
    * Document/message by which goods are declared for import
    * Customs clearance according to Annex B.1 (concerning
    * clearance for home use) to the Kyoto convention (CCC).
    */
   _930("Goods declaration for home use"),
   /**
    * Document/message issued by an importer notifying Customs
    * that goods have been removed from an importing means of
    * transport to the importer's premises under a Customs-
    * approved arrangement for immediate release, or
    * requesting authorization to do so.
    */
   _931("Customs immediate release declaration"),
   /**
    * Document/message whereby a Customs authority releases
    * goods under its control to be placed at the disposal of
    * the party concerned. Synonym: Customs release note.
    */
   _932("Customs delivery note"),
   /**
    * Generic term, sometimes referred to as Freight
    * declaration, applied to the documents providing the
    * particulars required by the Customs concerning the cargo
    * (freight) carried by commercial means of transport
    * (CCC).
    */
   _933("Cargo declaration (arrival)"),
   /**
    * Document/message in which a declarant (importer) states
    * the invoice or other price (e.g. selling price, price of
    * identical goods), and specifies costs for freight,
    * insurance and packing, etc., terms of delivery and
    * payment, any relationship with the trading partner,
    * etc., for the purpose of determining the Customs value
    * of goods imported.
    */
   _934("Value declaration"),
   /**
    * Document/message required by the Customs in an importing
    * country in which an exporter states the invoice or other
    * price (e.g. selling price, price of identical goods),
    * and specifies costs for freight, insurance and packing,
    * etc., terms of delivery and payment, for the purpose of
    * determining the Customs value in the importing country
    * of goods consigned to that country.
    */
   _935("Customs invoice"),
   /**
    * Document/message which, according to Article 106 of the
    * "Agreement concerning Postal Parcels" under the UPU
    * Convention, must accompany post parcels and in which the
    * contents of such parcels are specified.
    */
   _936("Customs declaration (post parcels)"),
   /**
    * Document/message in which an importer states the
    * pertinent information required by the competent body for
    * assessment of value-added tax.
    */
   _937("Tax declaration (value added tax)"),
   /**
    * Document/message containing a general tax declaration.
    */
   _938("Tax declaration (general)"),
   /**
    * Document/message containing the demand of tax.
    */
   _940("Tax demand"),
   /**
    * Document/message giving the permission to export
    * specified goods.
    */
   _941("Embargo permit"),
   /**
    * Document/message by which the sender declares goods for
    * Customs transit according to Annex E.1 (concerning
    * Customs transit) to the Kyoto convention (CCC).
    */
   _950("Goods declaration for Customs transit"),
   /**
    * International Customs transit document by which the
    * sender declares goods for carriage by rail in accordance
    * with the provisions of the 1952 International Convention
    * to facilitate the crossing of frontiers for goods
    * carried by rail (TIF Convention of UIC).
    */
   _951("TIF form"),
   /**
    * International Customs document (International Transit by
    * Road), issued by a guaranteeing association approved by
    * the Customs authorities, under the cover of which goods
    * are carried, in most cases under Customs seal, in road
    * vehicles and/or containers in compliance with the
    * requirements of the Customs TIR Convention of the
    * International Transport of Goods under cover of TIR
    * Carnets (UN/ECE).
    */
   _952("TIR carnet"),
   /**
    * EC customs transit document issued by EC customs
    * authorities for transit and/or temporary user of goods
    * within the EC.
    */
   _953("EC carnet"),
   /**
    * Customs certificate used in preferential goods
    * interchanges between EC countries and EC external
    * countries.
    */
   _954("EUR 1 certificate of origin"),
   /**
    * International Customs document (Admission Temporaire /
    * Temporary Admission) which, issued under the terms of
    * the ATA Convention (1961), incorporates an
    * internationally valid guarantee and may be used, in lieu
    * of national Customs documents and as security for import
    * duties and taxes, to cover the temporary admission of
    * goods and, where appropriate, the transit of goods. If
    * accepted for controlling the temporary export and
    * reimport of goods, international guarantee does not
    * apply (CCC).
    */
   _955("ATA carnet"),
   /**
    * A set of documents, replacing the various (national)
    * forms for Customs declaration within the EC, implemented
    * on 01-01-1988.
    */
   _960("Single administrative document"),
   /**
    * General response message to permit the transfer of data
    * from Customs to the transmitter of the previous message.
    */
   _961("General response (Customs)"),
   /**
    * Document response message to permit the transfer of data
    * from Customs to the transmitter of the previous message.
    */
   _962("Document response (Customs)"),
   /**
    * Error response message to permit the transfer of data
    * from Customs to the transmitter of the previous message.
    */
   _963("Error response (Customs)"),
   /**
    * Package response message to permit the transfer of data
    * from Customs to the transmitter of the previous message.
    */
   _964("Package response (Customs)"),
   /**
    * Tax calculation/confirmation response message to permit
    * the transfer of data from Customs to the transmitter of
    * the previous message.
    */
   _965("Tax calculation/confirmation response (Customs)"),
   /**
    * Document/message issued by the competent body for prior
    * allocation of a quota.
    */
   _966("Quota prior allocation certificate"),
   /**
    * Document which contains consignment information
    * concerning the wagons and their lading in a case of a
    * multiple wagon consignment.
    */
   _970("Wagon report"),
   /**
    * Document for a course of transit used for a carrier who
    * is neither the carrier at the beginning nor the arrival.
    * The transit carrier can directly invoice the expenses
    * for its part of the transport.
    */
   _971("Transit Conveyor Document"),
   /**
    * Document which is a copy of the rail consignment note
    * printed especially for the need of the forwarder.
    */
   _972("Rail consignment note forwarder copy"),
   /**
    * Document giving details for the carriage of excisable
    * goods on a duty-suspended basis.
    */
   _974("Duty suspended goods"),
   /**
    * A document providing proof that a transit declaration
    * has been accepted.
    */
   _975("Proof of transit declaration"),
   /**
    * Document for the carriage of containers. Syn: transfer
    * note.
    */
   _976("Container transfer note"),
   /**
    * Customs transit document for the carriage of shipments
    * of the NATO armed forces under Customs supervision.
    */
   _977("NATO transit document"),
   /**
    * Document containing the authorization from the relevant
    * authority for the international carriage of waste. Syn:
    * Transfrontier waste shipment permit.
    */
   _978("Transfrontier waste shipment authorization"),
   /**
    * Document certified by the carriers and the consignee to
    * be used for the international carriage of waste.
    */
   _979("Transfrontier waste shipment movement document"),
   /**
    * Document issued by Customs granting the end-use Customs
    * procedure.
    */
   _990("End use authorization"),
   /**
    * Document/message describing a contract with a government
    * authority.
    */
   _991("Government contract"),
   /**
    * Document/message describing an import document that is
    * used for statistical purposes.
    */
   _995("Statistical document, import"),
   /**
    * Message with application for opening of a documentary
    * credit.
    */
   _996("Application for documentary credit"),
   /**
    * Indication of the previous Customs document/message
    * concerning the same transaction.
    */
   _998("Previous Customs document/message");

   /** the code prfix used in this Enumeration. */
   public static final String PREFIX = "_";

   /** The short name for the code */
   public final String name;

   /**
    * Instantiates a new document name code.
    *
    * @param name the short name
    */
   private DocumentNameType(String name) {
      this.name = name;
   }

   /**
    * Gets the type by the provided code.
    *
    * @param code the code
    * @return the type by code or throws a IllegalArgumentException if the type does not exist.
    */
   public static DocumentNameType getTypeByCode(String code) {
      return valueOf(PREFIX + code);
   }

   /**
    * Checks if the given code is contained in the Enumeration.
    *
    * @param code the code
    * @return true, if is known code
    */
   public static boolean isKnownCode(final String code) {
      return KonikEnum.isKnownCode(DocumentNameType.class,code);
   }

   /**
    * Gets the code of this Enumeration
    *
    * @return the code
    */
   public String getCode() {
      return name().substring(1);
   }

}
