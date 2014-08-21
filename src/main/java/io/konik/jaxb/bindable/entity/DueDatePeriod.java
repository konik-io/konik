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
package io.konik.jaxb.bindable.entity;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import io.konik.zugferd.entity.Period;
import io.konik.zugferd.unqualified.ZfDate;

/**
 * = The period of time adapter. 
 */
@XmlType(propOrder = { "contractualDueDate" })
public class DueDatePeriod extends Period {

   @Valid
   @XmlElement(name = "CompleteDateTime")
   protected ZfDate contractualDueDate;

   /**
    * Gets the contractual due date.
    *
    * @return the contractual due date
    */
   public ZfDate getContractualDueDate() {
      return contractualDueDate;
   }

   /**
    * Sets the contractual due date.
    *
    * @param contractualDueDate the contractual due date
    * @return the period
    */
   public DueDatePeriod setContractualDueDate(ZfDate contractualDueDate) {
      this.contractualDueDate = contractualDueDate;
      return this;
   }

}
