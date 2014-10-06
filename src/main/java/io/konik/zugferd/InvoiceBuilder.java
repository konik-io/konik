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
package io.konik.zugferd;

import io.konik.zugferd.AbstractInvoiceBuilder;
import io.konik.zugferd.entity.ContextBuilder;
import io.konik.zugferd.profile.ConformanceLevel;
import io.konik.zugferd.profile.ProfileBuilder;

import javax.annotation.Generated;

/**
 * The {@link InvoiceBuilder} is a Builder for {@link Invoice} objects.
 */
@Generated("PojoBuilder")
public class InvoiceBuilder extends AbstractInvoiceBuilder
    implements Cloneable {

  /**
    * Creates a new {@link InvoiceBuilder}.
    *
    * @param conformanceLevel the conformance level
    */
  public InvoiceBuilder(ConformanceLevel conformanceLevel) {
     ContextBuilder context = new ContextBuilder().guideline(new ProfileBuilder().conformanceLevel(conformanceLevel));
     this.context(context);
  }
  
  /**
    * Instantiates a new invoice builder.
    */
  public InvoiceBuilder() {
  }
}
