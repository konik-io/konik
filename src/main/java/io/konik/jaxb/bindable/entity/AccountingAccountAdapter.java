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

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * = The Accounting Account to String Id Adapter.
 */
public class AccountingAccountAdapter extends XmlAdapter<AccountingAccount, String> {

   @Override
   public String unmarshal(AccountingAccount aa) throws Exception {
      if (aa == null) { return null; }
      return aa.id;
   }

   @Override
   public AccountingAccount marshal(String accountingAccount) throws Exception {
      if (accountingAccount == null) { return null; }
      return new AccountingAccount(accountingAccount);
   }

}
