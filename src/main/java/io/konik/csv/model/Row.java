package io.konik.csv.model;

import com.google.common.base.Objects;
import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;
import io.konik.zugferd.unece.codes.Reference;
import io.konik.zugferd.unece.codes.UnitOfMeasurement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Object representation of a single row in CSV file containing {@link io.konik.zugferd.Invoice}s
 */
public final class Row {

   private Header header = new Header();

   private TradeParty recipient = new TradeParty();

   private TradeParty issuer = new TradeParty();

   private List<Item> items = new LinkedList<Item>();

   private String comments = "";

   private String paymentReference = "";

   private File file = new File();

   public Header getHeader() {
      return header;
   }

   public void setHeader(Header header) {
      this.header = header;
   }

   public TradeParty getRecipient() {
      return recipient;
   }

   public void setRecipient(TradeParty recipient) {
      this.recipient = recipient;
   }

   public TradeParty getIssuer() {
      return issuer;
   }

   public void setIssuer(TradeParty issuer) {
      this.issuer = issuer;
   }

   public List<Item> getItems() {
      return items;
   }

   public void setItems(List<Item> items) {
      this.items = items;
   }

   public String getComments() {
      return comments;
   }

   public void setComments(String comments) {
      this.comments = comments;
   }

   public String getPaymentReference() {
      return paymentReference;
   }

   public void setPaymentReference(String paymentReference) {
      this.paymentReference = paymentReference;
   }

   public File getFile() {
      return file;
   }

   public void setFile(File file) {
      this.file = file;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Row)) return false;
      Row row = (Row) o;
      return Objects.equal(header, row.header) &&
            Objects.equal(recipient, row.recipient) &&
            Objects.equal(issuer, row.issuer) &&
            Objects.equal(items, row.items) &&
            Objects.equal(comments, row.comments) &&
            Objects.equal(paymentReference, row.paymentReference) &&
            Objects.equal(file, row.file);
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(header, recipient, issuer, items, comments, paymentReference, file);
   }

   @Override
   public String toString() {
      return "Row {" +
            "header=" + header +
            ", recipient=" + recipient +
            ", issuer=" + issuer +
            ", items=" + items +
            ", comments='" + comments + '\'' +
            ", paymentReference='" + paymentReference + '\'' +
            ", file=" + file +
            '}';
   }

   public static final class Header {
      private String invoiceNumber = "";
      private String type = "";
      private Date issued;
      private Date dueDate;
      private String note = "";
      private String reference = "";
      private String customerNumber = "";
      private CurrencyCode currency = CurrencyCode.EUR;

      public String getInvoiceNumber() {
         return invoiceNumber;
      }

      public Header setInvoiceNumber(String invoiceNumber) {
         this.invoiceNumber = invoiceNumber;
         return this;
      }

      public String getType() {
         return type;
      }

      public Header setType(String type) {
         this.type = type;
         return this;
      }

      public Date getIssued() {
         return issued;
      }

      public Header setIssued(Date issued) {
         this.issued = issued;
         return this;
      }

      public Date getDueDate() {
         return dueDate;
      }

      public Header setDueDate(Date dueDate) {
         this.dueDate = dueDate;
         return this;
      }

      public String getNote() {
         return note;
      }

      public Header setNote(String note) {
         this.note = note;
         return this;
      }

      public String getReference() {
         return reference;
      }

      public Header setReference(String reference) {
         this.reference = reference;
         return this;
      }

      public String getCustomerNumber() {
         return customerNumber;
      }

      public Header setCustomerNumber(String customerNumber) {
         this.customerNumber = customerNumber;
         return this;
      }

      public CurrencyCode getCurrency() {
         return currency;
      }

      public Header setCurrency(CurrencyCode currency) {
         this.currency = currency;
         return this;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof Header)) return false;
         Header header = (Header) o;
         return Objects.equal(invoiceNumber, header.invoiceNumber) &&
               Objects.equal(type, header.type) &&
               Objects.equal(issued, header.issued) &&
               Objects.equal(dueDate, header.dueDate) &&
               Objects.equal(note, header.note) &&
               Objects.equal(reference, header.reference) &&
               Objects.equal(customerNumber, header.customerNumber) &&
               Objects.equal(currency, header.currency);
      }

      @Override
      public int hashCode() {
         return Objects.hashCode(invoiceNumber, type, issued, dueDate, note, reference, customerNumber, currency);
      }

      @Override
      public String toString() {
         return "Header{" +
               "invoiceNumber='" + invoiceNumber + '\'' +
               ", type='" + type + '\'' +
               ", issued=" + issued +
               ", dueDate=" + dueDate +
               ", note='" + note + '\'' +
               ", reference='" + reference + '\'' +
               ", customerNumber='" + customerNumber + '\'' +
               ", currency=" + currency +
               '}';
      }
   }

   public static class Tax {
      private String number = "";
      private Reference type = Reference.FC;

      public Tax() {
      }

      public Tax(String number, Reference type) {
         this.number = number;
         this.type = type;
      }

      public String getNumber() {
         return number;
      }

      public Tax setNumber(String number) {
         this.number = number;
         return this;
      }

      public Reference getType() {
         return type;
      }

      public Tax setType(Reference type) {
         this.type = type;
         return this;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof Tax)) return false;
         Tax tax = (Tax) o;
         return Objects.equal(number, tax.number) &&
               Objects.equal(type, tax.type);
      }

      @Override
      public int hashCode() {
         return Objects.hashCode(number, type);
      }

      @Override
      public String toString() {
         return "Tax{" +
               "number='" + number + '\'' +
               ", type=" + type +
               '}';
      }
   }

   public static class TradeParty {
      private String name = "";
      private String contactName = "";
      private String addressLine1 = "";
      private String addressLine2 = "";
      private String city = "";
      private String postcode = "";
      private CountryCode countryCode;
      private String email = "";
      private List<Tax> taxes = new LinkedList<Tax>();
      private BankInformation bankInfo = new BankInformation();

      public String getName() {
         return name;
      }

      public TradeParty setName(String name) {
         this.name = name;
         return this;
      }

      public String getContactName() {
         return contactName;
      }

      public TradeParty setContactName(String contactName) {
         this.contactName = contactName;
         return this;
      }

      public String getAddressLine1() {
         return addressLine1;
      }

      public TradeParty setAddressLine1(String addressLine1) {
         this.addressLine1 = addressLine1;
         return this;
      }

      public String getAddressLine2() {
         return addressLine2;
      }

      public TradeParty setAddressLine2(String addressLine2) {
         this.addressLine2 = addressLine2;
         return this;
      }

      public String getCity() {
         return city;
      }

      public TradeParty setCity(String city) {
         this.city = city;
         return this;
      }

      public String getPostcode() {
         return postcode;
      }

      public TradeParty setPostcode(String postcode) {
         this.postcode = postcode;
         return this;
      }

      public String getEmail() {
         return email;
      }

      public TradeParty setEmail(String email) {
         this.email = email;
         return this;
      }

      public List<Tax> getTaxes() {
         return taxes;
      }

      public void setTaxes(List<Tax> taxes) {
         this.taxes = taxes;
      }

      public TradeParty addTax(Tax tax) {
         this.taxes.add(tax);
         return this;
      }

      public TradeParty addTax(Tax... tax) {
         this.taxes.addAll(Arrays.asList(tax));
         return this;
      }

      public BankInformation getBankInfo() {
         return bankInfo;
      }

      public TradeParty setBankInfo(BankInformation bankInfo) {
         this.bankInfo = bankInfo;
         return this;
      }

      public CountryCode getCountryCode() {
         return countryCode;
      }

      public TradeParty setCountryCode(CountryCode countryCode) {
         this.countryCode = countryCode;
         return this;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof TradeParty)) return false;
         TradeParty that = (TradeParty) o;
         return Objects.equal(name, that.name) &&
               Objects.equal(contactName, that.contactName) &&
               Objects.equal(addressLine1, that.addressLine1) &&
               Objects.equal(addressLine2, that.addressLine2) &&
               Objects.equal(city, that.city) &&
               Objects.equal(postcode, that.postcode) &&
               Objects.equal(countryCode, that.countryCode) &&
               Objects.equal(email, that.email) &&
               Objects.equal(taxes, that.taxes) &&
               Objects.equal(bankInfo, that.bankInfo);
      }

      @Override
      public int hashCode() {
         return Objects.hashCode(name, contactName, addressLine1, addressLine2, city, postcode, countryCode, email,
               taxes, bankInfo);
      }

      @Override
      public String toString() {
         return "TradeParty{" +
               "name='" + name + '\'' +
               ", contactName='" + contactName + '\'' +
               ", addressLine1='" + addressLine1 + '\'' +
               ", addressLine2='" + addressLine2 + '\'' +
               ", city='" + city + '\'' +
               ", postcode='" + postcode + '\'' +
               ", countryCode=" + countryCode +
               ", email='" + email + '\'' +
               ", taxes=" + taxes +
               ", bankInfo=" + bankInfo +
               '}';
      }
   }

   public static class Item {
      private String name = "";
      private BigDecimal quantity = BigDecimal.ZERO;
      private UnitOfMeasurement unit = UnitOfMeasurement.UNIT;
      private BigDecimal unitPrice = BigDecimal.ZERO;
      private BigDecimal taxPercent = BigDecimal.ZERO;

      public String getName() {
         return name;
      }

      public Item setName(String name) {
         this.name = name;
         return this;
      }

      public BigDecimal getQuantity() {
         return quantity;
      }

      public Item setQuantity(BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public UnitOfMeasurement getUnit() {
         return unit;
      }

      public Item setUnit(UnitOfMeasurement unit) {
         this.unit = unit;
         return this;
      }

      public BigDecimal getUnitPrice() {
         return unitPrice;
      }

      public Item setUnitPrice(BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BigDecimal getTaxPercent() {
         return taxPercent;
      }

      public Item setTaxPercent(BigDecimal taxPercent) {
         this.taxPercent = taxPercent;
         return this;
      }

      @Override
      public String toString() {
         return "Item {" +
               "type='" + name + '\'' +
               ", quantity=" + quantity +
               ", unit=" + unit +
               ", unitPrice=" + unitPrice +
               ", taxPercent=" + taxPercent +
               '}';
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof Item)) return false;
         Item item = (Item) o;
         return Objects.equal(name, item.name) &&
               Objects.equal(quantity, item.quantity) &&
               Objects.equal(unit, item.unit) &&
               Objects.equal(unitPrice, item.unitPrice) &&
               Objects.equal(taxPercent, item.taxPercent);
      }

      @Override
      public int hashCode() {
         return Objects.hashCode(name, quantity, unit, unitPrice, taxPercent);
      }
   }

   public static class BankInformation {
      private String bankName = "";
      private String bic = "";
      private String iban = "";

      public String getBankName() {
         return bankName;
      }

      public BankInformation setBankName(String bankName) {
         this.bankName = bankName;
         return this;
      }

      public String getBic() {
         return bic;
      }

      public BankInformation setBic(String bic) {
         this.bic = bic;
         return this;
      }

      public String getIban() {
         return iban;
      }

      public BankInformation setIban(String iban) {
         this.iban = iban;
         return this;
      }

      @Override
      public String toString() {
         return "BankInformation {" +
               "bankName='" + bankName + '\'' +
               ", bic='" + bic + '\'' +
               ", iban='" + iban + '\'' +
               '}';
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof BankInformation)) return false;
         BankInformation that = (BankInformation) o;
         return Objects.equal(bankName, that.bankName) &&
               Objects.equal(bic, that.bic) &&
               Objects.equal(iban, that.iban);
      }

      @Override
      public int hashCode() {
         return Objects.hashCode(bankName, bic, iban);
      }
   }

   public static class File {
      private String input = "";
      private String output = "";

      public String getInput() {
         return input;
      }

      public File setInput(String input) {
         this.input = input;
         return this;
      }

      public String getOutput() {
         return output;
      }

      public File setOutput(String output) {
         this.output = output;
         return this;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof File)) return false;
         File file = (File) o;
         return Objects.equal(input, file.input) &&
               Objects.equal(output, file.output);
      }

      @Override
      public int hashCode() {
         return Objects.hashCode(input, output);
      }

      @Override
      public String toString() {
         return "File {" +
               "input='" + input + '\'' +
               ", output='" + output + '\'' +
               '}';
      }
   }
}
