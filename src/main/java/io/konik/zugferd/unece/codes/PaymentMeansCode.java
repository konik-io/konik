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

import io.konik.util.KonikEnum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * = The Payment Means Code 
 * 
 * Represents payment code according to +UNCL 4461+.
 * 
 * @see http://www.unece.org/trade/untdid/d13b/tred/tred4461.htm[UN/EDIFACT 4461 Payment means code^]
 */
@XmlType(name = "PaymentMeansCodeType")
@XmlEnum
public enum PaymentMeansCode {
   /**
    * Instrument not defined
    * 
    * Not defined legally enforceable agreement between two or
    * more parties (expressing a contractual right or a right
    * to the payment of money).
    **/
   @XmlEnumValue("1")
   _1("Instrument not defined"),

   /**
    * Automated clearing house credit
    * 
    * A credit transaction made through the automated clearing
    * house system.
    **/
   @XmlEnumValue("2")
   _2("Automated clearing house credit"),

   /**
    * Automated clearing house debit
    * 
    * A debit transaction made through the automated clearing
    * house system.
    **/
   @XmlEnumValue("3")
   _3("Automated clearing house debit"),

   /**
    * ACH demand debit reversal
    * 
    * A request to reverse an ACH debit transaction to a
    * demand deposit account.
    **/
   @XmlEnumValue("4")
   _4("ACH demand debit reversal"),

   /**
    * ACH demand credit reversal
    * 
    * A request to reverse a credit transaction to a demand
    * deposit account.
    **/
   @XmlEnumValue("5")
   _5("ACH demand credit reversal"),

   /**
    * ACH demand credit
    * 
    * A credit transaction made through the ACH system to a
    * demand deposit account.
    **/
   @XmlEnumValue("6")
   _6("ACH demand credit"),

   /**
    * ACH demand debit
    * 
    * A debit transaction made through the ACH system to a
    * demand deposit account.
    **/
   @XmlEnumValue("7")
   _7("ACH demand debit"),

   /**
    * Hold
    * 
    * Indicates that the bank should hold the payment for
    * collection by the beneficiary or other instructions.
    **/
   @XmlEnumValue("8")
   _8("Hold"),

   /**
    * National or regional clearing
    * 
    * Indicates that the payment should be made using the
    * national or regional clearing.
    **/
   @XmlEnumValue("9")
   _9("National or regional clearing"),

   /**
    * In cash
    * 
    * Payment by currency (including bills and coins) in
    * circulation, including checking account deposits.
    **/
   @XmlEnumValue("10")
   _10("In cash"),

   /**
    * ACH savings credit reversal
    * 
    * A request to reverse an ACH credit transaction to a
    * savings account.
    **/
   @XmlEnumValue("11")
   _11("ACH savings credit reversal"),

   /**
    * ACH savings debit reversal
    * 
    * A request to reverse an ACH debit transaction to a
    * savings account.
    **/
   @XmlEnumValue("12")
   _12("ACH savings debit reversal"),

   /**
    * ACH savings credit
    * 
    * A credit transaction made through the ACH system to a
    * savings account.
    **/
   @XmlEnumValue("13")
   _13("ACH savings credit"),

   /**
    * ACH savings debit
    * 
    * A debit transaction made through the ACH system to a
    * savings account.
    **/
   @XmlEnumValue("14")
   _14("ACH savings debit"),

   /**
    * Bookentry credit
    * 
    * A credit entry between two accounts at the same bank
    * branch. Synonym: house credit.
    **/
   @XmlEnumValue("15")
   _15("Bookentry credit"),

   /**
    * Bookentry debit
    * 
    * A debit entry between two accounts at the same bank
    * branch. Synonym: house debit.
    **/
   @XmlEnumValue("16")
   _16("Bookentry debit"),

   /**
    * ACH demand cash concentration/disbursement (CCD) credit
    * 
    * A credit transaction made through the ACH system to a
    * demand deposit account using the CCD payment format.
    **/
   @XmlEnumValue("17")
   _17("ACH demand cash concentration/disbursement (CCD) credit"),

   /**
    * ACH demand cash concentration/disbursement (CCD) debit
    * 
    * A debit transaction made through the ACH system to a
    * demand deposit account using the CCD payment format.
    **/
   @XmlEnumValue("18")
   _18("ACH demand cash concentration/disbursement (CCD) debit"),

   /**
    * ACH demand corporate trade payment (CTP) credit
    * 
    * A credit transaction made through the ACH system to a
    * demand deposit account using the CTP payment format.
    **/
   @XmlEnumValue("19")
   _19("ACH demand corporate trade payment (CTP) credit"),

   /**
    * Cheque
    * 
    * Payment by a pre-printed form on which instructions are
    * given to an account holder (a bank or building society)
    * to pay a stated sum to a named recipient.
    **/
   @XmlEnumValue("20")
   _20("Cheque"),

   /**
    * Banker's draft
    * 
    * Issue of a banker's draft in payment of the funds.
    **/
   @XmlEnumValue("21")
   _21("Banker's draft"),

   /**
    * Certified banker's draft
    * 
    * Cheque drawn by a bank on itself or its agent. A person
    * who owes money to another buys the draft from a bank for
    * cash and hands it to the creditor who need have no fear
    * that it might be dishonoured.
    **/
   @XmlEnumValue("22")
   _22("Certified banker's draft"),

   /**
    * Bank cheque (issued by a banking or similar establishment)
    * 
    * Payment by a pre-printed form, which has been completed
    * by a financial institution, on which instructions are
    * given to an account holder (a bank or building society)
    * to pay a stated sum to a named recipient.
    **/
   @XmlEnumValue("23")
   _23("Bank cheque (issued by a banking or similar establishment)"),

   /**
    * Bill of exchange awaiting acceptance
    * 
    * Bill drawn by the creditor on the debtor but not yet
    * accepted by the debtor.
    **/
   @XmlEnumValue("24")
   _24("Bill of exchange awaiting acceptance"),

   /**
    * Certified cheque
    * 
    * Payment by a pre-printed form stamped with the paying
    * bank's certification on which instructions are given to
    * an account holder (a bank or building society) to pay a
    * stated sum to a named recipient .
    **/
   @XmlEnumValue("25")
   _25("Certified cheque"),

   /**
    * Local cheque
    * 
    * Indicates that the cheque is given local to the
    * recipient.
    **/
   @XmlEnumValue("26")
   _26("Local cheque"),

   /**
    * ACH demand corporate trade payment (CTP) debit
    * 
    * A debit transaction made through the ACH system to a
    * demand deposit account using the CTP payment format.
    **/
   @XmlEnumValue("27")
   _27("ACH demand corporate trade payment (CTP) debit"),

   /**
    * ACH demand corporate trade exchange (CTX) credit
    * 
    * A credit transaction made through the ACH system to a
    * demand deposit account using the CTX payment format.
    **/
   @XmlEnumValue("28")
   _28("ACH demand corporate trade exchange (CTX) credit"),

   /**
    * ACH demand corporate trade exchange (CTX) debit
    * 
    * A debit transaction made through the ACH system to a
    * demand account using the CTX payment format.
    **/
   @XmlEnumValue("29")
   _29("ACH demand corporate trade exchange (CTX) debit"),

   /**
    * Credit transfer
    * 
    * Payment by credit movement of funds from one account to
    * another.
    **/
   @XmlEnumValue("30")
   _30("Credit transfer"),

   /**
    * Debit transfer
    * 
    * Payment by debit movement of funds from one account to
    * another.
    **/
   @XmlEnumValue("31")
   _31("Debit transfer"),

   /**
    * ACH demand cash concentration/disbursement plus (CCD+)
    * 
    * credit
    * A credit transaction made through the ACH system to a
    * demand deposit account using the CCD+ payment format.
    **/
   @XmlEnumValue("32")
   _32("ACH demand cash concentration/disbursement plus (CCD+)"),

   /**
    * ACH demand cash concentration/disbursement plus (CCD+)
    * 
    * debit
    * A debit transaction made through the ACH system to a
    * demand deposit account using the CCD+ payment format.
    **/
   @XmlEnumValue("33")
   _33("ACH demand cash concentration/disbursement plus (CCD+)"),

   /**
    * ACH prearranged payment and deposit (PPD)
    * 
    * A consumer credit transaction made through the ACH
    * system to a demand deposit or savings account.
    **/
   @XmlEnumValue("34")
   _34("ACH prearranged payment and deposit (PPD)"),

   /**
    * ACH savings cash concentration/disbursement (CCD) credit
    * 
    * A credit transaction made through the ACH system to a
    * demand deposit or savings account.
    **/
   @XmlEnumValue("35")
   _35("ACH savings cash concentration/disbursement (CCD) credit"),

   /**
    * ACH savings cash concentration/disbursement (CCD) debit
    * 
    * A debit transaction made through the ACH system to a
    * savings account using the CCD payment format.
    **/
   @XmlEnumValue("36")
   _36("ACH savings cash concentration/disbursement (CCD) debit"),

   /**
    * ACH savings corporate trade payment (CTP) credit
    * 
    * A credit transaction made through the ACH system to a
    * savings account using the CTP payment format.
    **/
   @XmlEnumValue("37")
   _37("ACH savings corporate trade payment (CTP) credit"),

   /**
    * ACH savings corporate trade payment (CTP) debit
    * 
    * A debit transaction made through the ACH system to a
    * savings account using the CTP payment format.
    **/
   @XmlEnumValue("38")
   _38("ACH savings corporate trade payment (CTP) debit"),

   /**
    * ACH savings corporate trade exchange (CTX) credit
    * 
    * A credit transaction made through the ACH system to a
    * savings account using the CTX payment format.
    **/
   @XmlEnumValue("39")
   _39("ACH savings corporate trade exchange (CTX) credit"),

   /**
    * ACH savings corporate trade exchange (CTX) debit
    * 
    * A debit transaction made through the ACH system to a
    * savings account using the CTX payment format.
    **/
   @XmlEnumValue("40")
   _40("ACH savings corporate trade exchange (CTX) debit"),

   /**
    * ACH savings cash concentration/disbursement plus (CCD+)
    * 
    * credit
    * A credit transaction made through the ACH system to a
    * savings account using the CCD+ payment format.
    **/
   @XmlEnumValue("41")
   _41("ACH savings cash concentration/disbursement plus (CCD+)"),

   /**
    * Payment to bank account
    * 
    * Payment by an arrangement for settling debts that is
    * operated by the Post Office.
    **/
   @XmlEnumValue("42")
   _42("Payment to bank account"),

   /**
    * ACH savings cash concentration/disbursement plus (CCD+)
    * 
    * debit
    * A debit transaction made through the ACH system to a
    * savings account using the CCD+ payment format.
    **/
   @XmlEnumValue("43")
   _43("ACH savings cash concentration/disbursement plus (CCD+)"),

   /**
    * Accepted bill of exchange
    * 
    * Bill drawn by the creditor on the debtor and accepted by
    * the debtor.
    **/
   @XmlEnumValue("44")
   _44("Accepted bill of exchange"),

   /**
    * Referenced home-banking credit transfer
    * 
    * A referenced credit transfer initiated through home-
    * banking.
    **/
   @XmlEnumValue("45")
   _45("Referenced home-banking credit transfer"),

   /**
    * Interbank debit transfer
    * 
    * A debit transfer via interbank means.
    **/
   @XmlEnumValue("46")
   _46("Interbank debit transfer"),

   /**
    * Home-banking debit transfer
    * 
    * A debit transfer initiated through home-banking.
    **/
   @XmlEnumValue("47")
   _47("Home-banking debit transfer"),

   /**
    * Bank card
    * 
    * Payment by means of a card issued by a bank or other
    * financial institution.
    **/
   @XmlEnumValue("48")
   _48("Bank card"),

   /**
    * Direct debit
    * 
    * The amount is to be, or has been, directly debited to
    * the customer's bank account.
    **/
   @XmlEnumValue("49")
   _49("Direct debit"),

   /**
    * Payment by postgiro
    * 
    * A method for the transmission of funds through the
    * postal system rather than through the banking system.
    **/
   @XmlEnumValue("50")
   _50("Payment by postgiro"),

   /**
    * FR, norme 6 97-Telereglement CFONB (French Organisation for
    * 
    * Banking Standards) - Option A
    * A French standard procedure that allows a debtor to pay
    * an amount due to a creditor. The creditor will forward
    * it to its bank, which will collect the money on the bank
    * account of the debtor.
    **/
   @XmlEnumValue("51")
   _51("FR, norme 6 97-Telereglement CFONB (French Organisation for"),

   /**
    * Urgent commercial payment
    * 
    * Payment order which requires guaranteed processing by
    * the most appropriate means to ensure it occurs on the
    * requested execution date, provided that it is issued to
    * the ordered bank before the agreed cut-off time.
    **/
   @XmlEnumValue("52")
   _52("Urgent commercial payment"),

   /**
    * Urgent Treasury Payment
    * 
    * Payment order or transfer which must be executed, by the
    * most appropriate means, as urgently as possible and
    * before urgent commercial payments.
    **/
   @XmlEnumValue("53")
   _53("Urgent Treasury Payment"),

   /**
    * Promissory note
    * 
    * Payment by an unconditional promise in writing made by
    * one person to another, signed by the maker, engaging to
    * pay on demand or at a fixed or determinable future time
    * a sum certain in money, to order or to bearer.
    **/
   @XmlEnumValue("60")
   _60("Promissory note"),

   /**
    * Promissory note signed by the debtor
    * 
    * Payment by an unconditional promise in writing made by
    * the debtor to another person, signed by the debtor,
    * engaging to pay on demand or at a fixed or determinable
    * future time a sum certain in money, to order or to
    * bearer.
    **/
   @XmlEnumValue("61")
   _61("Promissory note signed by the debtor"),

   /**
    * Promissory note signed by the debtor and endorsed by a bank
    * 
    * Payment by an unconditional promise in writing made by
    * the debtor to another person, signed by the debtor and
    * endorsed by a bank, engaging to pay on demand or at a
    * fixed or determinable future time a sum certain in
    * money, to order or to bearer.
    **/
   @XmlEnumValue("62")
   _62("Promissory note signed by the debtor and endorsed by a bank"),

   /**
    * Promissory note signed by the debtor and endorsed by a
    * 
    * third party
    * Payment by an unconditional promise in writing made by
    * the debtor to another person, signed by the debtor and
    * endorsed by a third party, engaging to pay on demand or
    * at a fixed or determinable future time a sum certain in
    * money, to order or to bearer.
    **/
   @XmlEnumValue("63")
   _63("Promissory note signed by the debtor and endorsed by a"),

   /**
    * Promissory note signed by a bank
    * 
    * Payment by an unconditional promise in writing made by
    * the bank to another person, signed by the bank, engaging
    * to pay on demand or at a fixed or determinable future
    * time a sum certain in money, to order or to bearer.
    **/
   @XmlEnumValue("64")
   _64("Promissory note signed by a bank"),

   /**
    * Promissory note signed by a bank and endorsed by another
    * 
    * bank
    * Payment by an unconditional promise in writing made by
    * the bank to another person, signed by the bank and
    * endorsed by another bank, engaging to pay on demand or
    * at a fixed or determinable future time a sum certain in
    * money, to order or to bearer.
    **/
   @XmlEnumValue("65")
   _65("Promissory note signed by a bank and endorsed by another"),

   /**
    * Promissory note signed by a third party
    * 
    * Payment by an unconditional promise in writing made by a
    * third party to another person, signed by the third
    * party, engaging to pay on demand or at a fixed or
    * determinable future time a sum certain in money, to
    * order or to bearer.
    **/
   @XmlEnumValue("66")
   _66("Promissory note signed by a third party"),

   /**
    * Promissory note signed by a third party and endorsed by a
    * 
    * bank
    * Payment by an unconditional promise in writing made by a
    * third party to another person, signed by the third party
    * and endorsed by a bank, engaging to pay on demand or at
    * a fixed or determinable future time a sum certain in
    * money, to order or to bearer.
    **/
   @XmlEnumValue("67")
   _67("Promissory note signed by a third party and endorsed by a"),

   /**
    * Bill drawn by the creditor on the debtor
    * 
    * Bill drawn by the creditor on the debtor.
    **/
   @XmlEnumValue("70")
   _70("Bill drawn by the creditor on the debtor"),

   /**
    * Bill drawn by the creditor on a bank
    * 
    * Bill drawn by the creditor on a bank.
    **/
   @XmlEnumValue("74")
   _74("Bill drawn by the creditor on a bank"),

   /**
    * Bill drawn by the creditor, endorsed by another bank
    * 
    * Bill drawn by the creditor, endorsed by another bank.
    **/
   @XmlEnumValue("75")
   _75("Bill drawn by the creditor, endorsed by another bank"),

   /**
    * Bill drawn by the creditor on a bank and endorsed by a
    * 
    * third party
    * Bill drawn by the creditor on a bank and endorsed by a
    * third party.
    **/
   @XmlEnumValue("76")
   _76("Bill drawn by the creditor on a bank and endorsed by a"),

   /**
    * Bill drawn by the creditor on a third party
    * 
    * Bill drawn by the creditor on a third party.
    **/
   @XmlEnumValue("77")
   _77("Bill drawn by the creditor on a third party"),

   /**
    * Bill drawn by creditor on third party, accepted and
    * 
    * endorsed by bank
    * Bill drawn by creditor on third party, accepted and
    * endorsed by bank.
    **/
   @XmlEnumValue("78")
   _78("Bill drawn by creditor on third party, accepted and"),

   /**
    * Not transferable banker's draft
    * 
    * Issue a bankers draft not endorsable.
    **/
   @XmlEnumValue("91")
   _91("Not transferable banker's draft"),

   /**
    * Not transferable local cheque
    * 
    * Issue a cheque not endorsable in payment of the funds.
    **/
   @XmlEnumValue("92")
   _92("Not transferable local cheque"),

   /**
    * Reference giro
    * 
    * Ordering customer tells the bank to use the payment
    * system 'Reference giro'. Used in the Finnish national
    * banking system.
    **/
   @XmlEnumValue("93")
   _93("Reference giro"),

   /**
    * Urgent giro
    * 
    * Ordering customer tells the bank to use the bank service
    * 'Urgent Giro' when transferring the payment. Used in
    * Finnish national banking system.
    **/
   @XmlEnumValue("94")
   _94("Urgent giro"),

   /**
    * Free format giro
    * 
    * Ordering customer tells the ordering bank to use the
    * bank service 'Free Format Giro' when transferring the
    * payment. Used in Finnish national banking system.
    **/
   @XmlEnumValue("95")
   _95("Free format giro"),

   /**
    * Requested method for payment was not used
    * 
    * If the requested method for payment was or could not be
    * used, this code indicates that.
    **/
   @XmlEnumValue("96")
   _96("Requested method for payment was not used"),

   /**
    * Clearing between partners
    * 
    * Amounts which two partners owe to each other to be
    * compensated in order to avoid useless payments.
    **/
   @XmlEnumValue("97")
   _97("Clearing between partners"),

   /**
    * Mutually defined
    * 
    * A code assigned within a code list to be used on an
    * interim basis and as defined among trading partners
    * until a precise code can be assigned to the code list.
    **/
   @XmlEnumValue("ZZZ")
   _ZZZ("Mutually defined");
   
   /** prefix before the code in this Enumeration. */
   public static final String PREFIX = "_";

   /** the description for the code. */
   final public String description;

   /** The code. */
   final public String code;
   
   PaymentMeansCode(String descirption) {
      this.description = descirption;
      code = name().substring(1);
   }

   /**
    * Gets the type by the provided code.
    *
    * @param code the code
    * @return the type by code or throws a IllegalArgumentException if the type does not exist.
    */
   public static PaymentMeansCode getByCode(String code) {
      return valueOf(PREFIX + code);
   }

   /**
    * Checks if the given code is contained in the Enumeration.
    *
    * @param code the code
    * @return true, if is known code
    */
   public static boolean isKnownCode(final String code) {
     return KonikEnum.isKnownCode(PaymentMeansCode.class, code);
   }
   
   @Override
   public String toString() {
      return new StringBuilder().append("[").append(code).append("] ").append(description).toString();
   }
}
