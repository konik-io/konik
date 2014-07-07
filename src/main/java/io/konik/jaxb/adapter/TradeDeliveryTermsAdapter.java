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
package io.konik.jaxb.adapter;

import static io.konik.util.Strings.isNullOrEmpty;
import io.konik.jaxb.bindable.entity.TradeDeliveryTerms;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * = The Trade Delivery Terms Adapter to String
 */
public class TradeDeliveryTermsAdapter extends XmlAdapter<TradeDeliveryTerms, String> {

   @Override
   public String unmarshal(TradeDeliveryTerms dradeDeliveryTerms) throws Exception {
      if (dradeDeliveryTerms == null) { return null; }
      return dradeDeliveryTerms.getDeliveryTypeCode();
   }

   @Override
   public TradeDeliveryTerms marshal(String deliveryTypeCode) throws Exception {
      if (isNullOrEmpty(deliveryTypeCode)) { return null; }
      return new TradeDeliveryTerms(deliveryTypeCode);
   }

}
