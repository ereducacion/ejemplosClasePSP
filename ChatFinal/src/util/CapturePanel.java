package util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
	public class CapturePanel extends JPanel implements Consumer {

      private JTextArea output;

      public CapturePanel() {
          setLayout(new BorderLayout());
          output = new JTextArea();
          add(new JScrollPane(output));
      }

      @Override
      public void appendText(final String text) {
          if (EventQueue.isDispatchThread()) {
              output.append(text);
              output.setCaretPosition(output.getText().length());
          } else {

              EventQueue.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                      appendText(text);
                  }
              });

          }
      }
  }



