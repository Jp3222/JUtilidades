/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jsoftware.com.jutil.model.utils;

import java.io.Serializable;

/**
 *
 * @author juanp
 */
public interface Monitoreable extends Serializable {

    public void devLog(String msg);

    public void errLog(String msg);
}
