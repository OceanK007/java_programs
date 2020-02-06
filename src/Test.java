public class Test 
{
	public static void main(String[] args) {
		String s = "5</dealer_number>\r\n" + 
				"    <batch_number>  </batch_number>\r\n" + 
				"    <sequence_number>   </sequence_number>\r\n" + 
				"    <card_code></card_code>\r\n" + 
				"    <adjust_amount>50.00</adjust_amount>\r\n" + 
				"    <reason_code>34</reason_code>\r\n" + 
				"    <trans_datetime>2019-02-28T00:00:00</trans_datetime>\r\n" + 
				"    <adjustment_descript>Prepaid Funds to Marathon </adjustment_descript>\r\n" + 
				"    <pay_to_dealer_number>92775</pay_to_dealer_number>\r\n" + 
				"  </cc_pay_adjust>\r\n" + 
				"  <cnpay_indicator>\r\n" + 
				"  </dealer_pay_nonpay>\r\n" + 
				"  <cc_pay_notification>\r\n" + 
				"    <cc_pay_notice_number>90200590901</cc_pay_notice_number>\r\n" + 
				"    <pay_to_dealer_number>92775</pay_to_dealer_number>\r\n" + 
				"    <customer_number>490653</customer_number>\r\n" + 
				"    <pay_type>3</pay_type>\r\n" + 
				"    <notification_date>2019-02-28</notification_date>\r\n" + 
				"    <pay_date>2019-03-01</pay_date>\r\n" + 
				"    <process_date>2019-02-28</process_date>\r\n" + 
				"    <deposit_date>2019-02-28</deposit_date>\r\n" + 
				"  </cc_pay_notification>\r\n" + 
				"  <cc_pay_adjust>\r\n" + 
				"    <cc_pay_notice_number>90200590901</cc_pay_notice_number>\r\n" + 
				"    <line_number>1</line_number>\r\n" + 
				"    <dealer_number>9277";
		System.out.println(s.getBytes().length);
	}
}
