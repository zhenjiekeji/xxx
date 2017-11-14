package com.uk.sec.framework.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.slf4j.Logger;
import org.springframework.util.Assert;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.util.ObjectUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.uk.sec.framework.extremeImpl.PageRequestFactory;
import com.uk.sec.framework.file.callback.UploadFileCallback;
import com.uk.sec.framework.log.LogFactory;
import com.uk.sec.framework.security.action.UserView;
import com.uk.sec.framework.util.ConvertRegisterHelper;

public abstract class BaseStruts2Action extends ActionSupport implements RequestAware {
    protected final Logger     logger       = LogFactory.LOGGER_ACTION;
    protected Map              requestMap   = null;
    /**
     * 控制ectabe存储状态的参数.
     */
    public final static String NOTIFY_STATE = "?notifyState=true";
    public final static String NOTIFY_ATTR  = "notifyState";

    static {
        // 注册converters
        ConvertRegisterHelper.registerConverters();
    }

    public void copyProperties(Object target, Object source) {
        BeanUtils.copyProperties(target, source);
    }

    public <T> T copyProperties(Class<T> destClass, Object orig) {
        return BeanUtils.copyProperties(destClass, orig);
    }

    public void setRequest(Map request) {
        this.requestMap = request;
    }

    public void savePage(Page page, PageRequest pageRequest) {
        savePage("", page, pageRequest);
    }

    /**
     * 用于一个页面有多个extremeTable是使用
     *
     * @param tableId
     *            等于extremeTable的tableId属性
     */
    public void savePage(String tableId, Page page, PageRequest pageRequest) {
        Assert.notNull(tableId, "tableId must be not null");
        Assert.notNull(page, "page must be not null");

        getRequest().setAttribute(tableId + "page", page);
        getRequest().setAttribute(tableId + "totalRows", new Integer(page.getTotalCount()));
        getRequest().setAttribute(tableId + "pageRequest", pageRequest);
    }

    public PageRequest newPageRequest(String defaultSortColumns) {
        return PageRequestFactory.newPageRequest(ServletActionContext.getRequest(), defaultSortColumns, getEctableId());
    }

    public PageRequest newPageRequest(String defaultSortColumns, String tableId) {
        return PageRequestFactory.newPageRequest(ServletActionContext.getRequest(), defaultSortColumns, tableId);
    }

    public PageRequest newPageRequest(String defaultSortColumns, int defaultPageSize, String tableId) {
        return PageRequestFactory.newPageRequest(ServletActionContext.getRequest(),
                                                 defaultSortColumns,
                                                 defaultPageSize,
                                                 tableId);
    }

    public PageRequest newPageRequest(String defaultSortColumns, int defaultPageSize) {
        return PageRequestFactory.newPageRequest(ServletActionContext.getRequest(),
                                                 defaultSortColumns,
                                                 defaultPageSize,
                                                 getEctableId());
    }

    public boolean isNullOrEmptyString(Object o) {
        return ObjectUtils.isNullOrEmptyString(o);
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    // 下面是扩展功能的内容

    /** 弹出页回调方法 */
    private String callbackmethod;
    private String target;

    public String getCallbackmethod() {
        return this.callbackmethod;
    }

    public void setCallbackmethod(String callbackmethod) {
        this.callbackmethod = callbackmethod;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    /** 系统指定错误页面 */
    protected static String SYSTEM_ERROR_JSP              = "/components/system_error.jsp";

    /** 无权操作页面 */
    protected static String SYSTEM_NO_PERMISSION_JSP      = "/components/system_no_permission.jsp";

    /**
     * 系统默认的成功返回页面.
     */
    protected static String OPERATION_SUCCESS_JSP         = "/commons/operation_success.jsp";
    /** 返回失败页面 */
    protected static String OPERATE_FAILURE_JSP           = "/commons/operate_failure.jsp";

    protected static String OPERATION_SUCCESS_FORWARD_JSP = "/commons/operation_success_forward.jsp";
    /**
     * 邮件确认时的成功页面
     */
    protected static String EMAIL_SUCCESS_JSP             = "/commons/email_success.jsp";
    /**
     * 在成功页面显示的信息.
     */
    private String          successMessage;
    /**
     * 成功页面跳转的目的地页面.
     */
    private String          forwardPath;

    /**
     * 成功页面返回的目的地页面
     */
    private String          returnPath;

    /**
     * 返回跳转到系统默认的成功返回页面的地址串.
     *
     * @param successMessage
     *            在成功页面显示的信息.
     * @param returndPath
     *            成功页面返回的目的地页面.
     * @return
     */
    public String defaultOperationSuccess(String successMessage, String returnPath) {
        this.successMessage = successMessage;
        this.returnPath = returnPath;
        return OPERATION_SUCCESS_JSP;
    }

    /**
     * 返回跳转失败页面
     */
    public String defaultOperateFailure(String successMessage, String returnPath) {
        this.successMessage = successMessage;
        this.returnPath = returnPath;
        return OPERATE_FAILURE_JSP;
    }

    /**
     * @param successMessage
     *            在成功页面显示的信息.
     */
    public String defaultEmailSuccess(String successMessage) {
        this.successMessage = successMessage;
        return EMAIL_SUCCESS_JSP;
    }

    /**
     * 返回跳转到系统默认的成功返回页面的地址串.
     *
     * @param successMessage
     *            在成功页面显示的信息.
     * @param returndPath
     *            成功页面返回的目的地页面.
     * @param forwardPath
     *            成功页面跳转的目的地页面.
     * @return
     */
    public String defaultOperationSuccess(String successMessage, String returnPath, String forwardPath) {
        this.successMessage = successMessage;
        this.returnPath = returnPath;
        this.forwardPath = forwardPath;
        return OPERATION_SUCCESS_FORWARD_JSP;
    }

    /**
     * @return the successMessage
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * @param successMessage
     *            the successMessage to set
     */
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    /**
     * @return the forwardPath
     */
    public String getForwardPath() {
        return forwardPath;
    }

    /**
     * @param forwardPath
     *            the forwardPath to set
     */
    public void setForwardPath(String forwardPath) {
        this.forwardPath = forwardPath;
    }

    /**
     * @return the returnPath
     */
    public String getReturnPath() {
        return returnPath;
    }

    /**
     * @param returnPath
     *            the returnPath to set
     */
    public void setReturnPath(String returnPath) {
        this.returnPath = returnPath;
    }

    /** 批量删除的时候使用,删除成功的数据 */
    protected List<BaseDataView> successDataList;

    public List<BaseDataView> getSuccessDataList() {
        return this.successDataList;
    }

    public void setSuccessDataList(List<BaseDataView> successDataList) {
        this.successDataList = successDataList;
    }

    /** 批量删除的时候使用,删除失败的数据 */
    protected List<BaseDataView> errorDataList;

    public List<BaseDataView> getErrorDataList() {
        return this.errorDataList;
    }

    public void setErrorDataList(List<BaseDataView> errorDataList) {
        this.errorDataList = errorDataList;
    }

    /** 批量删除的时候使用,删除成功的数据 个数 */
    protected int successNum = 0;

    public int getSuccessNum() {
        return this.successNum;
    }

    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }

    /** 批量删除的时候使用,删除失败的个数数据 */
    protected int errorNum = 0;

    public int getErrorNum() {
        return this.errorNum;
    }

    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }

    public boolean isNullOrEmptyStringOrZero(int o) {
        return o == 0;
    }

    public boolean isNullOrEmptyStringOrZero(double o) {
        return o == 0;
    }

    public boolean isNullOrEmptyStringOrZero(short o) {
        return o == 0;
    }

    public boolean isNullOrEmptyStringOrZero(float o) {
        return 0 == o;
    }

    private final String DEFAULT_UPLOAD_FILE_DIR = "/download";

    private File[]       uploadFile;

    private String[]     uploadFileFileName;

    public String[] processUploadFile() {
        int fileCounts = uploadFile.length;
        System.out.println("UploadFile counts :" + fileCounts);
        // 按照File[]的长度初始化一个用于返回文件上传结果的String数组,这个数组的元素与File[]的元素一一对应
        String[] uploadFileResult = new String[fileCounts];
        // 判断子类是否实现了UploadFileCallback接口,如果实现了该接口,文件处理逻辑移交到子类实现.
        if (this instanceof UploadFileCallback) {
            UploadFileCallback callback = (UploadFileCallback) this;
            for (int i = 0; i < this.uploadFile.length; i++) {
                uploadFileResult[i] = callback.callback(this.uploadFile[i], this.uploadFileFileName[i]);
            }
        } else {
            // 子类没有实现UploadFileCallback接口,采用默认的文件处理方式:将上传的文件保存到应用的files目录中.
            String appDir = this.getRequest().getSession().getServletContext().getRealPath(DEFAULT_UPLOAD_FILE_DIR)
                            + File.separator;
            File dir = new File(appDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            for (int i = 0; i < this.uploadFile.length; i++) {
                String filePath = appDir + this.uploadFileFileName[i];
                try {
                    // 把临时文件复制到目标路径下
                    FileUtils.copyFile(this.uploadFile[i], new File(filePath));
                    // 文件地址作为上传结果返回
                    String serverDir = this.getRequest().getSession().getServletContext().getRealPath("")
                                       + File.separator;
                    uploadFileResult[i] = filePath.substring(serverDir.length());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return uploadFileResult;
    }

    public File[] getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File[] uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String[] getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String[] uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    /**
     * ----------------------------件上传----E N *
     * D---------------------------------------------------
     */

    /**
     * 获得session中的登录信息.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public UserView<String> getUserView() {
        return (UserView<String>) this.getRequest().getSession().getAttribute(UserView.SESSION_USER_VIEW);
    }

    /**
     * 把UserView对象放入session中.
     *
     * @param userView
     */
    public void setUserView(UserView<String> userView) {
        this.getRequest().getSession().setAttribute(UserView.SESSION_USER_VIEW, userView);
    }

    /**
     * 获得登录的用户ID.
     *
     * @return
     */
    public String getLoginId() {
        return this.getUserView().getLoginId();
    }

    /**
     * 获得登录的用户名.
     *
     * @return
     */
    public String getLoginName() {
        return this.getUserView().getLoginName();
    }

    /**
     * 获得登录的用户的显示名.
     *
     * @return
     */
    public String getLoginDisplayName() {
        return this.getUserView().getLoginDisplayName();
    }

    /**
     * 子类覆盖该方法,返回ectable 的tableId,应与页面上ectable标签中的值一直.
     *
     * @return
     * @author xzw
     */
    public String getEctableId() {
        return "";
    }
}
