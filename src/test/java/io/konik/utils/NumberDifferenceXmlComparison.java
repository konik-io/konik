package io.konik.utils;

import java.math.BigDecimal;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceListener;
import org.w3c.dom.Node;

@SuppressWarnings("javadoc")
public class NumberDifferenceXmlComparison implements DifferenceListener {
   
   @Override
   public int differenceFound(Difference difference) {
      String nodeName = getNodeName(difference);
      String controlValue = difference.getControlNodeDetail().getValue();
      String testValue = difference.getTestNodeDetail().getValue();
      if (nodeName.endsWith("Amount") || nodeName.endsWith("Quantity")|| nodeName.endsWith("Measure")|| nodeName.endsWith("Percent")) {
         int result = new BigDecimal(controlValue).compareTo(new BigDecimal(testValue));
         if (result == 0) { return RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR; }
      }
      return RETURN_ACCEPT_DIFFERENCE;
   }

   private static String getNodeName(Difference difference) {
      Node parentNode = difference.getControlNodeDetail().getNode().getParentNode();
      if (parentNode == null) {return "";}
      return parentNode.getLocalName();
   }

   @Override
   public void skippedComparison(Node control, Node test) {}
}