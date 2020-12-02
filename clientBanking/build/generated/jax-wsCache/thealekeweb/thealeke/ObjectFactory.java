
package thealeke;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the thealeke package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Check_QNAME = new QName("http://thealeke/", "check");
    private final static QName _ActivateResponse_QNAME = new QName("http://thealeke/", "activateResponse");
    private final static QName _DeactivateResponse_QNAME = new QName("http://thealeke/", "deactivateResponse");
    private final static QName _Transaction1_QNAME = new QName("http://thealeke/", "transaction1");
    private final static QName _GetAccountsResponse_QNAME = new QName("http://thealeke/", "get_accountsResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://thealeke/", "loginResponse");
    private final static QName _UpdateAccountResponse_QNAME = new QName("http://thealeke/", "updateAccountResponse");
    private final static QName _CheckAccResponse_QNAME = new QName("http://thealeke/", "check_accResponse");
    private final static QName _Activate_QNAME = new QName("http://thealeke/", "activate");
    private final static QName _ActivateempResponse_QNAME = new QName("http://thealeke/", "activateempResponse");
    private final static QName _AddnewsResponse_QNAME = new QName("http://thealeke/", "AddnewsResponse");
    private final static QName _Deactivateemp_QNAME = new QName("http://thealeke/", "deactivateemp");
    private final static QName _GrantTranferResponse_QNAME = new QName("http://thealeke/", "GrantTranferResponse");
    private final static QName _Transaction1Response_QNAME = new QName("http://thealeke/", "transaction1Response");
    private final static QName _DeactivateempResponse_QNAME = new QName("http://thealeke/", "deactivateempResponse");
    private final static QName _Viewnews_QNAME = new QName("http://thealeke/", "Viewnews");
    private final static QName _GetEmployees_QNAME = new QName("http://thealeke/", "get_employees");
    private final static QName _CheckResponse_QNAME = new QName("http://thealeke/", "checkResponse");
    private final static QName _CheckEmployeeResponse_QNAME = new QName("http://thealeke/", "checkEmployeeResponse");
    private final static QName _GetEmployeesResponse_QNAME = new QName("http://thealeke/", "get_employeesResponse");
    private final static QName _Deactivate_QNAME = new QName("http://thealeke/", "deactivate");
    private final static QName _UpdateAccount_QNAME = new QName("http://thealeke/", "updateAccount");
    private final static QName _CheckAcc_QNAME = new QName("http://thealeke/", "check_acc");
    private final static QName _Login_QNAME = new QName("http://thealeke/", "login");
    private final static QName _Addnews_QNAME = new QName("http://thealeke/", "Addnews");
    private final static QName _GetTransfersResponse_QNAME = new QName("http://thealeke/", "get_transfersResponse");
    private final static QName _CheckEmployee_QNAME = new QName("http://thealeke/", "checkEmployee");
    private final static QName _ViewnewsResponse_QNAME = new QName("http://thealeke/", "ViewnewsResponse");
    private final static QName _GrantTranfer_QNAME = new QName("http://thealeke/", "GrantTranfer");
    private final static QName _GetAccounts_QNAME = new QName("http://thealeke/", "get_accounts");
    private final static QName _GetTransfers_QNAME = new QName("http://thealeke/", "get_transfers");
    private final static QName _Activateemp_QNAME = new QName("http://thealeke/", "activateemp");
    private final static QName _CheckTransfer_QNAME = new QName("http://thealeke/", "checkTransfer");
    private final static QName _CheckTransferResponse_QNAME = new QName("http://thealeke/", "checkTransferResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: thealeke
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEmployeesResponse }
     * 
     */
    public GetEmployeesResponse createGetEmployeesResponse() {
        return new GetEmployeesResponse();
    }

    /**
     * Create an instance of {@link CheckEmployeeResponse }
     * 
     */
    public CheckEmployeeResponse createCheckEmployeeResponse() {
        return new CheckEmployeeResponse();
    }

    /**
     * Create an instance of {@link CheckResponse }
     * 
     */
    public CheckResponse createCheckResponse() {
        return new CheckResponse();
    }

    /**
     * Create an instance of {@link CheckAcc }
     * 
     */
    public CheckAcc createCheckAcc() {
        return new CheckAcc();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link UpdateAccount }
     * 
     */
    public UpdateAccount createUpdateAccount() {
        return new UpdateAccount();
    }

    /**
     * Create an instance of {@link Deactivate }
     * 
     */
    public Deactivate createDeactivate() {
        return new Deactivate();
    }

    /**
     * Create an instance of {@link GetAccounts }
     * 
     */
    public GetAccounts createGetAccounts() {
        return new GetAccounts();
    }

    /**
     * Create an instance of {@link GetTransfers }
     * 
     */
    public GetTransfers createGetTransfers() {
        return new GetTransfers();
    }

    /**
     * Create an instance of {@link GrantTranfer }
     * 
     */
    public GrantTranfer createGrantTranfer() {
        return new GrantTranfer();
    }

    /**
     * Create an instance of {@link ViewnewsResponse }
     * 
     */
    public ViewnewsResponse createViewnewsResponse() {
        return new ViewnewsResponse();
    }

    /**
     * Create an instance of {@link Activateemp }
     * 
     */
    public Activateemp createActivateemp() {
        return new Activateemp();
    }

    /**
     * Create an instance of {@link CheckTransfer }
     * 
     */
    public CheckTransfer createCheckTransfer() {
        return new CheckTransfer();
    }

    /**
     * Create an instance of {@link CheckTransferResponse }
     * 
     */
    public CheckTransferResponse createCheckTransferResponse() {
        return new CheckTransferResponse();
    }

    /**
     * Create an instance of {@link CheckEmployee }
     * 
     */
    public CheckEmployee createCheckEmployee() {
        return new CheckEmployee();
    }

    /**
     * Create an instance of {@link Addnews }
     * 
     */
    public Addnews createAddnews() {
        return new Addnews();
    }

    /**
     * Create an instance of {@link GetTransfersResponse }
     * 
     */
    public GetTransfersResponse createGetTransfersResponse() {
        return new GetTransfersResponse();
    }

    /**
     * Create an instance of {@link UpdateAccountResponse }
     * 
     */
    public UpdateAccountResponse createUpdateAccountResponse() {
        return new UpdateAccountResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link CheckAccResponse }
     * 
     */
    public CheckAccResponse createCheckAccResponse() {
        return new CheckAccResponse();
    }

    /**
     * Create an instance of {@link GetAccountsResponse }
     * 
     */
    public GetAccountsResponse createGetAccountsResponse() {
        return new GetAccountsResponse();
    }

    /**
     * Create an instance of {@link ActivateResponse }
     * 
     */
    public ActivateResponse createActivateResponse() {
        return new ActivateResponse();
    }

    /**
     * Create an instance of {@link DeactivateResponse }
     * 
     */
    public DeactivateResponse createDeactivateResponse() {
        return new DeactivateResponse();
    }

    /**
     * Create an instance of {@link Transaction1 }
     * 
     */
    public Transaction1 createTransaction1() {
        return new Transaction1();
    }

    /**
     * Create an instance of {@link Check }
     * 
     */
    public Check createCheck() {
        return new Check();
    }

    /**
     * Create an instance of {@link GrantTranferResponse }
     * 
     */
    public GrantTranferResponse createGrantTranferResponse() {
        return new GrantTranferResponse();
    }

    /**
     * Create an instance of {@link Transaction1Response }
     * 
     */
    public Transaction1Response createTransaction1Response() {
        return new Transaction1Response();
    }

    /**
     * Create an instance of {@link Viewnews }
     * 
     */
    public Viewnews createViewnews() {
        return new Viewnews();
    }

    /**
     * Create an instance of {@link GetEmployees }
     * 
     */
    public GetEmployees createGetEmployees() {
        return new GetEmployees();
    }

    /**
     * Create an instance of {@link DeactivateempResponse }
     * 
     */
    public DeactivateempResponse createDeactivateempResponse() {
        return new DeactivateempResponse();
    }

    /**
     * Create an instance of {@link Activate }
     * 
     */
    public Activate createActivate() {
        return new Activate();
    }

    /**
     * Create an instance of {@link AddnewsResponse }
     * 
     */
    public AddnewsResponse createAddnewsResponse() {
        return new AddnewsResponse();
    }

    /**
     * Create an instance of {@link Deactivateemp }
     * 
     */
    public Deactivateemp createDeactivateemp() {
        return new Deactivateemp();
    }

    /**
     * Create an instance of {@link ActivateempResponse }
     * 
     */
    public ActivateempResponse createActivateempResponse() {
        return new ActivateempResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link News }
     * 
     */
    public News createNews() {
        return new News();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Check }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "check")
    public JAXBElement<Check> createCheck(Check value) {
        return new JAXBElement<Check>(_Check_QNAME, Check.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "activateResponse")
    public JAXBElement<ActivateResponse> createActivateResponse(ActivateResponse value) {
        return new JAXBElement<ActivateResponse>(_ActivateResponse_QNAME, ActivateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeactivateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "deactivateResponse")
    public JAXBElement<DeactivateResponse> createDeactivateResponse(DeactivateResponse value) {
        return new JAXBElement<DeactivateResponse>(_DeactivateResponse_QNAME, DeactivateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transaction1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "transaction1")
    public JAXBElement<Transaction1> createTransaction1(Transaction1 value) {
        return new JAXBElement<Transaction1>(_Transaction1_QNAME, Transaction1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "get_accountsResponse")
    public JAXBElement<GetAccountsResponse> createGetAccountsResponse(GetAccountsResponse value) {
        return new JAXBElement<GetAccountsResponse>(_GetAccountsResponse_QNAME, GetAccountsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "updateAccountResponse")
    public JAXBElement<UpdateAccountResponse> createUpdateAccountResponse(UpdateAccountResponse value) {
        return new JAXBElement<UpdateAccountResponse>(_UpdateAccountResponse_QNAME, UpdateAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAccResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "check_accResponse")
    public JAXBElement<CheckAccResponse> createCheckAccResponse(CheckAccResponse value) {
        return new JAXBElement<CheckAccResponse>(_CheckAccResponse_QNAME, CheckAccResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Activate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "activate")
    public JAXBElement<Activate> createActivate(Activate value) {
        return new JAXBElement<Activate>(_Activate_QNAME, Activate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateempResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "activateempResponse")
    public JAXBElement<ActivateempResponse> createActivateempResponse(ActivateempResponse value) {
        return new JAXBElement<ActivateempResponse>(_ActivateempResponse_QNAME, ActivateempResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddnewsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "AddnewsResponse")
    public JAXBElement<AddnewsResponse> createAddnewsResponse(AddnewsResponse value) {
        return new JAXBElement<AddnewsResponse>(_AddnewsResponse_QNAME, AddnewsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deactivateemp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "deactivateemp")
    public JAXBElement<Deactivateemp> createDeactivateemp(Deactivateemp value) {
        return new JAXBElement<Deactivateemp>(_Deactivateemp_QNAME, Deactivateemp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrantTranferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "GrantTranferResponse")
    public JAXBElement<GrantTranferResponse> createGrantTranferResponse(GrantTranferResponse value) {
        return new JAXBElement<GrantTranferResponse>(_GrantTranferResponse_QNAME, GrantTranferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transaction1Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "transaction1Response")
    public JAXBElement<Transaction1Response> createTransaction1Response(Transaction1Response value) {
        return new JAXBElement<Transaction1Response>(_Transaction1Response_QNAME, Transaction1Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeactivateempResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "deactivateempResponse")
    public JAXBElement<DeactivateempResponse> createDeactivateempResponse(DeactivateempResponse value) {
        return new JAXBElement<DeactivateempResponse>(_DeactivateempResponse_QNAME, DeactivateempResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Viewnews }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "Viewnews")
    public JAXBElement<Viewnews> createViewnews(Viewnews value) {
        return new JAXBElement<Viewnews>(_Viewnews_QNAME, Viewnews.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "get_employees")
    public JAXBElement<GetEmployees> createGetEmployees(GetEmployees value) {
        return new JAXBElement<GetEmployees>(_GetEmployees_QNAME, GetEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "checkResponse")
    public JAXBElement<CheckResponse> createCheckResponse(CheckResponse value) {
        return new JAXBElement<CheckResponse>(_CheckResponse_QNAME, CheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "checkEmployeeResponse")
    public JAXBElement<CheckEmployeeResponse> createCheckEmployeeResponse(CheckEmployeeResponse value) {
        return new JAXBElement<CheckEmployeeResponse>(_CheckEmployeeResponse_QNAME, CheckEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "get_employeesResponse")
    public JAXBElement<GetEmployeesResponse> createGetEmployeesResponse(GetEmployeesResponse value) {
        return new JAXBElement<GetEmployeesResponse>(_GetEmployeesResponse_QNAME, GetEmployeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deactivate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "deactivate")
    public JAXBElement<Deactivate> createDeactivate(Deactivate value) {
        return new JAXBElement<Deactivate>(_Deactivate_QNAME, Deactivate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "updateAccount")
    public JAXBElement<UpdateAccount> createUpdateAccount(UpdateAccount value) {
        return new JAXBElement<UpdateAccount>(_UpdateAccount_QNAME, UpdateAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAcc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "check_acc")
    public JAXBElement<CheckAcc> createCheckAcc(CheckAcc value) {
        return new JAXBElement<CheckAcc>(_CheckAcc_QNAME, CheckAcc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addnews }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "Addnews")
    public JAXBElement<Addnews> createAddnews(Addnews value) {
        return new JAXBElement<Addnews>(_Addnews_QNAME, Addnews.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransfersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "get_transfersResponse")
    public JAXBElement<GetTransfersResponse> createGetTransfersResponse(GetTransfersResponse value) {
        return new JAXBElement<GetTransfersResponse>(_GetTransfersResponse_QNAME, GetTransfersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "checkEmployee")
    public JAXBElement<CheckEmployee> createCheckEmployee(CheckEmployee value) {
        return new JAXBElement<CheckEmployee>(_CheckEmployee_QNAME, CheckEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewnewsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "ViewnewsResponse")
    public JAXBElement<ViewnewsResponse> createViewnewsResponse(ViewnewsResponse value) {
        return new JAXBElement<ViewnewsResponse>(_ViewnewsResponse_QNAME, ViewnewsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrantTranfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "GrantTranfer")
    public JAXBElement<GrantTranfer> createGrantTranfer(GrantTranfer value) {
        return new JAXBElement<GrantTranfer>(_GrantTranfer_QNAME, GrantTranfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "get_accounts")
    public JAXBElement<GetAccounts> createGetAccounts(GetAccounts value) {
        return new JAXBElement<GetAccounts>(_GetAccounts_QNAME, GetAccounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransfers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "get_transfers")
    public JAXBElement<GetTransfers> createGetTransfers(GetTransfers value) {
        return new JAXBElement<GetTransfers>(_GetTransfers_QNAME, GetTransfers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Activateemp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "activateemp")
    public JAXBElement<Activateemp> createActivateemp(Activateemp value) {
        return new JAXBElement<Activateemp>(_Activateemp_QNAME, Activateemp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "checkTransfer")
    public JAXBElement<CheckTransfer> createCheckTransfer(CheckTransfer value) {
        return new JAXBElement<CheckTransfer>(_CheckTransfer_QNAME, CheckTransfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://thealeke/", name = "checkTransferResponse")
    public JAXBElement<CheckTransferResponse> createCheckTransferResponse(CheckTransferResponse value) {
        return new JAXBElement<CheckTransferResponse>(_CheckTransferResponse_QNAME, CheckTransferResponse.class, null, value);
    }

}
